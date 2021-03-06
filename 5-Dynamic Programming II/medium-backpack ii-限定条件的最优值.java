public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int i, j, n = A.length;
        //f[i][j]为只计算前i个物品，背包总容量j的情况下的最大价值
        int[][] f = new int [n+1][m+1];
        
        for(i=0; i<=m; i++)
            f[0][i] = 0;
        for(i=0; i<=n; i++)
            f[i][0] = 0;
            
        for(i=1; i<=n; i++){
            for(j=1; j<=m; j++){
                if(j>=A[i-1]){
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-A[i-1]]+V[i-1]);
                }
                else{
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[n][m];
    }
}
