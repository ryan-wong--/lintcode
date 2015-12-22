/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null)
            return null;
        
        if(p.right != null){//若有右儿子，则一直左下去
            TreeNode cur = p.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }
        else if(p == root){//若没有右儿子，且为根，则没有后继
            return null;
        }
        else{//若没有右儿子也不是根，则用两个指针寻找p的位置，其中cur一定要找到
        //p为止，suc则当cur小于p的时候不跟随，最后suc就是p的后继
            TreeNode cur = root;
            TreeNode suc = root;
            while(cur.val!=p.val){
                if(cur.val>p.val){
                    suc = cur;
                    cur = cur.left;
                }
                else{
                    cur = cur.right;
                }
            }
            if(suc == root && suc.val<p.val){
                return null;
            }
            else{
                return suc;
            }
        }
    }
}
