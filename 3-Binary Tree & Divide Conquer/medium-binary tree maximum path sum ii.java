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
     * @param root the root of binary tree.
     * @return an integer
     */
    private class result_type{
        //single_path表示当前根的树里面自顶向下的单向最大路径，要么经过左子树、要么经过右子树
        //max_path表示当前根的树里面的最大路径，要么经过根贯通左右子树、要么只被限定在左右子树其中之一
        int single_path;
        result_type(int a){
            this.single_path = a;
        }
    }
    private result_type traverse(TreeNode root){
        if(root==null){
            return new result_type(0);//因为节点权值有可能是负的，为了使空节点不影响后面max函数的工作
        }
        
        result_type result = new result_type(0);
        
        result_type left = traverse(root.left);
        result_type right = traverse(root.right);
        
        result.single_path = Math.max(left.single_path, right.single_path) + root.val;
        
        return result;
    }
    public int maxPathSum2(TreeNode root) {
        // write your code here
        result_type result = traverse(root);
        return result.single_path;
    }
}
