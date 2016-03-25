public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     * 该题中，物品价格就是其重量
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int i, j, n = A.length;
        int[][] f = new int [n+1][m+1];
        
        for(i=0; i<=m; i++)
            f[0][i] = 0;
        for(i=0; i<=n; i++)
            f[i][0] = 0;
            
        for(i=1; i<=n; i++){
            for(j=1; j<=m; j++){
                if(j>=A[i-1]){
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-A[i-1]]+A[i-1]);
                }
                else{
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[n][m];
    }
}
