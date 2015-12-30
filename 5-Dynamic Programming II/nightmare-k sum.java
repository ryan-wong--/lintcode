public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        int n = A.length;
        int i, select, sum;//i:n, select:k, sum:target
        int floor;
        //f[i][select][sum]意为：数组中前i个数选择select个之和为sum的方案数
        int[][][] f = new int[n+1][k+1][target+1];
        
        //1.对于每个i，select=1的情况需单独讨论作为初始化
        //2.对于当前的i，新的方案要么需要A[i-1]，要么不需要，把这两种情况加起来就可以了
        for(i=1; i<=n; i++){
            for(select=1; select<=k; select++){
                for(sum=1; sum<=target; sum++){
                    floor = Math.max(0, sum-A[i-1]);
                    if(select==1){
                        if(f[i-1][select][sum]==1 || A[i-1]==sum)
                            f[i][select][sum] = 1;
                    }
                    else
                        f[i][select][sum] = f[i-1][select-1][floor] + f[i-1][select][sum];
                }
            }
        }
        return f[n][k][target];
    }
}

