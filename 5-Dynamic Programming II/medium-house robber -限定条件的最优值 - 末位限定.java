public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     * 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
     * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。
     */
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n==0){
            return 0;
        } else if(n==1){
            return A[0];
        } else if(n==2){
            return Math.max(A[0], A[1]);
        } else if(n==3){
            return Math.max(A[0]+A[2], A[1]);
        }
        
        long[] f = new long[n];//f[i]表示i号房子必被抢的前提下，抢劫犯最大收益
        f[0] = A[0];
        f[1] = A[1];
        f[2] = A[0]+A[2];
        long max_ = Integer.MIN_VALUE;
        
        for(int i=3; i<n; i++){
            //上一个被抢的要么是i-2要么是i-3，如果是i-4的话那么肯定还能塞进i-2房，所以不用讨论i-4以下部分
            f[i] = Math.max(f[i-2], f[i-3]) + A[i];
        }
        return Math.max(f[n-2], f[n-1]);
    }
}