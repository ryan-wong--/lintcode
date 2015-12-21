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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result_ = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        TreeNode temp = root;
        int i = 0;
        while(cur!=null || !stack.empty()){
            while(cur!=null){//从root开始，把左儿子都加入栈
                stack.push(cur);
                cur = cur.left;
            }
            
            temp = stack.pop();//栈顶出，值加入遍历队列
            result_.add(temp.val);
            
            if(temp.right!=null)//把已出栈的元素的右儿子加入栈
                cur = temp.right;
        }//栈空且当前节点为空之后返回
        return result_;
    }
}
