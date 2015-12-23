public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int size = nums.length;
        if(size==0||nums==null){
            return 0;
        }
        //重要：f[i]为包含nums[i]的最长子序列长度，这样才方便比较
        int[] f = new int[size];
        int i, j, max_ = 0;
        f[0] = 1;
        
        for(i=1; i<size; i++){
            f[i] = 1;
            for(j=0; j<i; j++){
                //由f[]的定义，只需比较子序列j和子序列i的末尾元素即可
                if(nums[j]<=nums[i]){
                    f[i] = f[i]>=f[j]+1? f[i]:f[j]+1;
                }
            }
            max_ = max_>f[i]? max_:f[i];
        }
        //注意返回的不一定是f[size-1]
        return max_;
    }
}

