public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     * 给一个整数数组，调整每个数的大小，使得相邻的两个数的差小于一个给定的整数target，
     * 调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。
     * 注意：每个数都是1~100的正整数
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int cel, floor, min_, adjust, n = A.size(), val = 100;
        if(n<=1){
            return 0;
        }
        //f[i][j]是计算到A[i]之后最后一个数调整为j的最小调整代价
        int[][] f = new int[n][val+1];
        for(int i=1; i<=val; i++){
            f[0][i] = Math.abs(A.get(0)-i);
        }
        //容易证明，若A[]前i个元素调整代价最小时，那么前i-1个元素调整代价也是最小的
        //递推式f[i][j] = min(k){f[i-1][k] + |A(i)-j|}, j-target<=k<=j+target.
        for(int i=1; i<n; i++){
            for(int j=1; j<=val; j++){
                cel = Math.min(j+target, val);
                floor = Math.max(j-target, 1);
                min_ = Integer.MAX_VALUE;
                f[i][j] = min_;
                adjust = Math.abs(A.get(i)-j);
                for(int k=floor; k<=cel; k++){
                    min_ = Math.min(min_, f[i-1][k]+adjust);
                }
                f[i][j] = min_;
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int j=1; j<=val; j++){
            result = Math.min(result, f[n-1][j]);
        }
        
        return result;
    }
}