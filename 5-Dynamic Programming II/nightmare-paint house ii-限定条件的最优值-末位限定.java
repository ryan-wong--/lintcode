public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     * 输入一个n*k的二阶数组costs，n是房子数目，k是颜色数目，costs[i][j]表示i号房子涂成j色的开销
     * 相邻房子不能涂相同颜色，求涂完所有房子的最小开销
     */
    private int min_(int[] f, int j){//返回数组中除了下标j的数之外的最小值
        int res = Integer.MAX_VALUE;
        int a = 0;
        while(a < f.length){
            if(a==j){
                a++;
                continue;
            }
            res = Math.min(res, f[a]);
            a++;
        }
        return res;
    }
    
    public int minCostII(int[][] costs) {
        // Write your code here
        if(costs.length == 0){
            return 0;
        }
        
        int n = costs.length, k = costs[0].length;
        
        int[][] f = new int[n][k];//f[i][j]表示到i号house时选择j色的最小开销
        for(int j=0; j<k; j++){
            f[0][j] = costs[0][j];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<k; j++){
                f[i][j] = min_(f[i-1], j) + costs[i][j];
                //System.out.printf("f[%d][%d]=%d\n",i,j,f[i][j]);
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int j=0; j<k; j++){
            res = Math.min(res, f[n-1][j]);
        }
        return res;
    }
}