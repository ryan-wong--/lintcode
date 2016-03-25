public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
     * 比如，给出下列数字三角形：

        [

             [2],

            [3,4],

           [6,5,7],

          [4,1,8,3]

        ]

        从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int m, n, i, j;
        m = triangle.length;
        n = m;
        
        int[] path = new int[2*m+1];//只用O(n)空间
        path[0] = triangle[0][0];
        path[1] = triangle[0][0];
        if(m<2){
            return path[1];
        }
        
        for(i=2; i<=m; i++){
            for(j=1; j<=i; j++){
                if(j==1){
                    path[m+j] = path[1] + triangle[i-1][j-1];
                }
                else if(j==i){
                    path[m+j] = path[i-1] + triangle[i-1][j-1];
                }
                else {
                    path[m+j] = Math.min(path[j-1], path[j]) + triangle[i-1][j-1];
                }
            }
            for(j=1; j<=i; j++){
                path[j] = path[m+j];
            }
        }
        
        int min_ = path[1];
        for(j=2; j<=m; j++){
            min_ = Math.min(min_, path[j]);
        }
        
        return min_;
    }
}

