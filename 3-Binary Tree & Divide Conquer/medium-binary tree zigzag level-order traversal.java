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
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行） 
 */
 
 
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        //知识点1：迭代数列的初始化方法：不给ArrayList限定类型
        ArrayList result = new ArrayList();
        int is_left = 1;
        if (root == null) {
            return result;
        }
        
        //知识点2：队列的初始化方法：用LinkedList，添加和删除操作分别用offer和poll
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<Integer> stack = new Stack<Integer>();//加多一个栈反转插入顺序即可
        queue.offer(root);

        //知识点3：层次遍历的初始化方法，每次while循环都是树里面的一层，里面再嵌套一个for循环用来对本层节点进行遍历
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();//把队列中所有元素都出栈，但每出一个就要加新的进来
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if(is_left==1)
                    level.add(head.val);
                else
                    stack.push(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
                
            }
            if(is_left!=1){
                while(!stack.isEmpty()){
                    level.add(stack.pop());
                }
            }
            result.add(level);
            is_left = is_left*(-1);
        }

        return result;
    }
}