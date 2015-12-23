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
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        //若A、B都不在root下，则返回null；若A、B有且仅有一个在root下，返回A或B；
        //若都在root下，返回最终结果
        // write your code here
        if(root==null || root==A || root==B){
            return root;
        }
        
        //divide
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        //conquer
        if(left!=null && right!=null){//等价于：root就是最终结果
            return root;
        }
        else if(left!=null){
            return left;
        }
        else if(right!=null){
            return right;
        }
        else {
            return null;
        }
    }
}
