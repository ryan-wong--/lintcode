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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode result, current;
    public BSTIterator(TreeNode root) {
        // write your code here
        while(!stack.empty()){
            stack.pop();
        }
        current = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if(current!=null || !stack.empty()){
            return true;
        }
        return false;
    }
    
    //@return: return next node
    //作用是，不断调用next就能把数据按中序遍历输出
    public TreeNode next() {
        // write your code here
        while(current!=null){
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        result = current;
        current = current.right;
        return result;
    }
}
