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
     * @return: True if this Binary tree is Balanced, or false.
     */
    //从树的底部开始判断才行得通，用递归
    private int depth_(TreeNode root){
        if(root==null){
            return 0;
        }
        if(Math.abs(depth_(root.left)-depth_(root.right)) > 1){
            return -1;
        }
        if(depth_(root.left)<0 || depth_(root.right)<0){
            return -1;
        }
        else{
            return Math.max(depth_(root.left), depth_(root.right)) + 1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        int depth = depth_(root);
        if(depth < 0)
            return false;
        else 
            return true;
    }
}
