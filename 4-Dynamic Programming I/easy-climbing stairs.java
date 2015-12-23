public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n==0){
            return 1;
        }
        
        int i;
        int[] count = new int[n+1];
        
        count[0] = 1;
        count[1] = 1;
        
        for(i=2; i<=n; i++){//只需考虑走一步和走两步两种情况
            count[i] = count[i-2] + count[i-1];
        }
        return count[n];
    }
}
