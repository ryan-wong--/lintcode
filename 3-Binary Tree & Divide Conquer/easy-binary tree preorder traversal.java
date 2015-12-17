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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> nodes_ = new Stack<TreeNode>();
        ArrayList<Integer> result_ = new ArrayList<Integer>();
        if(root==null){
            return result_;
        }
        //1.root入栈
        //2.栈顶出栈并加入队列
        //3.出栈元素的右儿子、左儿子依次入栈，若栈不空，回到2.
        //4.返回该队列
        nodes_.push(root);
        while(!nodes_.empty()){
            TreeNode temp = nodes_.pop();
            result_.add(temp.val);
            if(temp.right!=null){
                nodes_.push(temp.right);
            }
            if(temp.left!=null){
                nodes_.push(temp.left);
            }
        }
        
        return result_;
    }
}
