public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * 不能有连续三个篱笆柱子被涂相同颜色
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if(n==0){
            return 0;
        }
        else if(n==1){
            return k;
        }
        
        int[] same = new int[n];//表示和前一个柱子相同色时的绘图总方法数
        int[] diff = new int[n];//表示和前一个柱子不同色时的绘图总方法数
        
        same[1] = k;
        diff[1] = k*(k-1);
        
        for(int i=2; i<n; i++){
            same[i] = diff[i-1];
            diff[i] = (k-1)*(diff[i-1] + same[i-1]);//只要i柱和i-1柱不一样就可以
        }
        
        return same[n-1] + diff[n-1];
        
    }
}