class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     * 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
     * 设计一个算法来找到最大的利润。你最多可以完成 k 笔交易。(卖出的当天可以再买入)
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        // 双递推数列的例题
        int n = prices.length;
        if(k==0 || n==0){
            return 0;
        }
        
        if(k>=n/2){
            int i = 0, profit = 0;
            while(i < n-1){
                if(prices[i+1] > prices[i]){
                    //这里不需要i+=2，因为若prices[i+1]-prices[i]和
                    //prices[i+2]-prices[i+1]都被遍历到了，则可以合并为
                    //prices[i+2]-prices[i]，并不会导致买卖次数超过k
                    profit += prices[i+1]-prices[i];
                }
                i++;
            }
            return profit;
        }
        //sell_now[i][j]：前i天最多j次交易且第i天必须卖出的最大利润
        int[][] sell_now = new int[n][k+1];
        //total[i][j]：前i天最多j次交易的最大利润
        int[][] total = new int[n][k+1];
        
        for(int i=1; i<n; i++){
            for(int j=1; j<k+1; j++){
                int today_benifit = prices[i]-prices[i-1];
                //第i天卖出的对应买入是/不是第i-1天
                sell_now[i][j] = Math.max(total[i-1][j-1]+today_benifit, sell_now[i-1][j]+today_benifit);
                //最后一次卖出是/不是第i天
                total[i][j] = Math.max(sell_now[i][j], total[i-1][j]);
            }
        }
        
        return total[n-1][k];
    }
};
