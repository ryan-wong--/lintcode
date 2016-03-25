public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
     
    public int numSquares(int n) {
        // Write your code here
        if(n == 0 || n == 1){
            return n;
        }
        
        int[] f = new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        for(int i=0; i*i<=n; i++){
            f[i*i] = 1;
        }
        
        /*for(int i=2; i<=n; i++){
            if(f[i] == 1){
                continue;
            }
            int min_ = Integer.MAX_VALUE;
            for(int j=1; j<=i/2; j++){
                min_ = Math.min(min_, f[j]+f[i-j]);
            }
            f[i] = min_;
            //System.out.printf("modified: f[%d] = %d\n",i,f[i]);
        }
        return f[n];*/
        //以上的O(n^2)TLE
        //下面的O(n^1.5)AC
        
        // 从小到大找任意数a
        for(int a=0; a<=n; a++){
            // 从小到大找平方数bｘb
            for(int b=0; a+b*b<=n; b++){
                // 因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
                f[a + b*b] = Math.min(f[a] + 1, f[a + b*b]);
            }
        }
        return f[n];
    }
}