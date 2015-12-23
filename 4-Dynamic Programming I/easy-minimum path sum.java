public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int m, n, i, j;
        m = grid.length;
        n = grid[0].length;
        
        int[][] path = new int[m][n];
        
        for(i=0; i<m; i++){
            if(i==0){
                path[i][0] = grid[0][0];
            }
            else{
                path[i][0] = path[i-1][0] + grid[i][0];
            }
        }
        for(j=0; j<n; j++){
            if(j==0){
                path[0][j] = grid[0][0];
            }
            else{
                path[0][j] = path[0][j-1] + grid[0][j];
            }
        }
        if(m<2 || n<2){
            return path[m-1][n-1];
        }
        
        for(i=1; i<m; i++){
            for(j=1; j<n; j++){//只需考虑上面来和左边来两种情况
                path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + grid[i][j];
            }
        }
        return path[m-1][n-1];
    }
}

