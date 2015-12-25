public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，
     * 你能有多少种不同的方法爬到楼顶部？
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
