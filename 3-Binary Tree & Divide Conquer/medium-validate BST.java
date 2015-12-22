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
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        //use inorder traverse array to examine if the tree is permitted
        //实际上用了中序遍历法
        ArrayList<Integer> a = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null)
            return true;
        
        TreeNode cur = root;
        TreeNode temp = root;
        int i = 0;
        while(cur!=null || !stack.empty()){
            while(cur!=null){//把左儿子都加入栈
                stack.push(cur);
                cur = cur.left;
            }
            
            temp = stack.pop();//栈顶出，值加入遍历队列
            a.add(temp.val);
            if(i>=1 && a.get(i)<=a.get(i-1))
                return false;
            i++;
            if(temp.right!=null)//把已出栈的元素的右儿子加入栈
                cur = temp.right;
        }
        return true;
    }
}
