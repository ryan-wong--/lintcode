public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m, n;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        int count[][] = new int[m][n];
        int i, j, sign;
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        
        count[0][0] = 1;
        sign = 0;
        for(i=1; i<n; i++){//初始化第一行
            if(sign == 1){
                count[0][i] = 0;
                continue;
            }
            else{
                count[0][i] = 1;
            }
            if(obstacleGrid[0][i]==1){
                count[0][i] = 0;
                sign = 1;
            }
        }
        sign = 0;
        for(i=0; i<m; i++){//初始化第一列
            if(sign == 1){
                count[i][0] = 0;
                continue;
            }
            else{
                count[i][0] = 1;
            }
            if(obstacleGrid[i][0]==1){
                count[i][0] = 0;
                sign = 1;
            }
        }
        if(m<=1 || n<=1){
            return count[m-1][n-1];
        }
        
        
        for(i=1; i<m; i++){
            for(j=1; j<n; j++){
                if(obstacleGrid[i][j]==1){
                    count[i][j] = 0;//把障碍所在点的路径数置0即可
                }
                else{
                    count[i][j] = count[i-1][j] + count[i][j-1];
                }
            }
        }
        
        return count[m-1][n-1];
    }
}
