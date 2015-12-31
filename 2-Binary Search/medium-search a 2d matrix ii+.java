public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     * 考虑下列矩阵：

        [

            [1, 3, 5, 7],

            [2, 4, 7, 8],

            [3, 5, 9, 10]

        ]

        给出target = 3，返回 2
     */
    public int searchMatrix(int[][] matrix, int target) {
        // check corner case
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        // from bottom left to top right
        int n = matrix.length;
        int m = matrix[0].length;
        //从左下角开始搜索
        int x = n - 1;
        int y = 0;
        int count = 0;
        
        //被搜索对象是以matrix[x][y]为左下角，原矩阵右上角为右上角的子矩阵
        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {//舍弃掉一整列，因为matrix[x][y] 已经是该列最大的数却还是比target小
                y++;
            } else if (matrix[x][y] > target) {//舍弃掉一整行，因为matrix[x][y] 已经是该行最小的数却还是比target大
                x--;
            } else {//舍弃掉一整行一整列，因为该行该列已经不可能存在target
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}