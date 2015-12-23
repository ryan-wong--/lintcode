public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
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

