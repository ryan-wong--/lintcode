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
     * @return: An integer.
     */
    private class result_type{
        //single_path表示当前根的树里面自顶向下的单向最大路径，要么经过左子树、要么经过右子树
        //max_path表示当前根的树里面的最大路径，要么经过根贯通左右子树、要么只被限定在左右子树其中之一，不一定经过根
        int single_path, max_path;
        result_type(int a, int b)
        {
            this.single_path = a;
            this.max_path = b;
        }
    }
    private result_type traverse(TreeNode root){
        if(root==null){
            return new result_type(0, Integer.MIN_VALUE);//因为节点权值有可能是负的，为了使空节点不影响后面max函数的工作
        }
        
        result_type left = traverse(root.left);
        result_type right = traverse(root.right);
        
        result_type result = new result_type(0, Integer.MIN_VALUE);
        result.single_path = Math.max(left.single_path, right.single_path) + root.val;
        result.single_path = Math.max(0, result.single_path);
        
        result.max_path = Math.max(left.max_path, right.max_path);
        result.max_path = Math.max(result.max_path, left.single_path+right.single_path+root.val);
        
        return result;
    }
    public int maxPathSum(TreeNode root) {
        // write your code here
        result_type result = traverse(root);
        return result.max_path;
    }
}
