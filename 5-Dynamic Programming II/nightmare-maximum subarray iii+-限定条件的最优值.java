public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     * 样例：给出数组[-1,4,-2,3,-2,3]以及k=2，返回 8
     */
    //返回nums数组从下标from到下标end的最大子数组和
    private int max_sub_sub(int[] nums, int from, int end){
        int sum = 0, max = 0;
        for(int i=0; i<=end-from; i++){
            sum += nums[i+from];
            if(i>0){
                max = Math.max(max, sum);
            }
            else{
                max = sum;
            }
            sum = Math.max(sum, 0);
        }
        return max;
    }
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int sum, n = nums.length;
        if(n<=0 || k>n){
            return 0;
        }
        //f[i][j]:到nums[i]时，分为j块的最大子数组和
        int[][] f = new int[n][k+1];
        
        sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            if(i!=0)
                f[i][1] = Math.max(f[i-1][1], sum);
            else
                f[i][1] = sum;
            sum = Math.max(sum, 0);
        }
        //递推：f[i][j] = max(a){f[a][j-1] + max_sub_sub(a+1,i)}, j-2<=a<=i-1
        for(int j=2; j<=k; j++){
            for(int i=j-1; i<=n-1; i++){
                int max_ = Integer.MIN_VALUE;
                for(int a=j-2; a<=i-1; a++){
                    max_ = Math.max(max_, f[a][j-1]+max_sub_sub(nums,a+1,i));
                }
                f[i][j] = max_;
            }
        }
        
        return f[n-1][k];
    }
}
