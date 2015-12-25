public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     * 有一个机器人的位于一个M×N个网格左上角（下图中标记为'Start'）。

     * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
     * 问有多少条不同的路径？
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int count[][] = new int[m][n];
        int i, j;
        for(i=0; i<n; i++){
            count[0][i] = 1;
        }
        for(i=0; i<m; i++){
            count[i][0] = 1;
        }
        if(m<=1 || n<=1){
            return count[m-1][n-1];
        }
        
        for(i=1; i<m; i++){
            for(j=1; j<n; j++){
                count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        
        return count[m-1][n-1];
    }
}

