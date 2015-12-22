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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        
        //知识点1：迭代数列的初始化方法：不给ArrayList限定类型
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }
        
        //知识点2：队列的初始化方法：用LinkedList，添加和删除操作分别用offer和poll
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        //知识点3：层次遍历的初始化方法，每次while循环都是树里面的一层，里面再嵌套一个for循环用来对本层节点进行遍历
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();//把队列中所有元素都出栈，但每出一个就要加新的进来
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
