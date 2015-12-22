/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 //按照算法导论做
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    private TreeNode parent = new TreeNode(0);
    private TreeNode parent_next = new TreeNode(0);
    private int is_left = 1;
    
    //返回关键字为value的节点
    private TreeNode find_node(TreeNode root, int value){
        TreeNode z = root;
        if(z==null){
            return null;
        }
        while(z.val != value){
            if(z.val<value){
                parent = z;
                is_left = 0;
                z = z.right;
            }
            else {
                parent = z;
                is_left = 1;
                z = z.left;
            }
            if(z==null){
                return null;
            }
        }
        return z;
    }
    
    //删除suc节点，该节点无左子树
    private void del_suc(TreeNode root, TreeNode suc){
        int value = suc.val;
        TreeNode z = root;
        while(z.val != value){
            if(z.val<value){
                parent_next = z;
                z = z.right;
            }
            else {
                parent_next = z;
                z = z.left;
            }
        }
        parent_next.left = z.right;
        return;
    }
    
    //返回z节点的中序遍历后继
    private TreeNode next_(TreeNode root, TreeNode z){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int find = 0;
        TreeNode current = root;
        while(current!=null || !stack.empty()){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            if(find == 1){
                find = 0;
                break;
            }
            if(z.val == current.val){
                find = 1;
            }
            current = current.right;
        }
        return current;
    }
    
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        TreeNode ini = new TreeNode(0);
        parent = ini;
        ini.left = root;
        TreeNode z = find_node(root, value);
        if(z == null){
            return root;
        }
        
        if(z.left==null){
            if(is_left==1){
                parent.left = z.right;
            }
            else {
                parent.right = z.right;
            }
            if(z==root){
                ini = parent;
            }
        }
        else if(z.right==null){
            if(is_left==1){
                parent.left = z.left;
            }
            else {
                parent.right = z.left;
            }
            if(z==root){
                ini = parent;
            }
        }
        else {
            TreeNode suc = next_(root, z);
            if(suc.val == z.right.val){
                z.right = suc.right;
                z.val = suc.val;
            }
            else {
                del_suc(root, suc);
                z.val = suc.val;
            }
        }
        
        return ini.left;
        
    }
}
