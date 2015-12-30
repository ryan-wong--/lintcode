class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     * ��������һ�����飬���ĵ�i��Ԫ����һ֧�����Ĺ�Ʊ�ڵ�i��ļ۸�
     * ���һ���㷨���ҵ�������������������� k �ʽ��ס�(�����ĵ������������)
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        // ˫�������е�����
        int n = prices.length;
        if(k==0 || n==0){
            return 0;
        }
        
        if(k>=n/2){
            int i = 0, profit = 0;
            while(i < n-1){
                if(prices[i+1] > prices[i]){
                    //���ﲻ��Ҫi+=2����Ϊ��prices[i+1]-prices[i]��
                    //prices[i+2]-prices[i+1]�����������ˣ�����Ժϲ�Ϊ
                    //prices[i+2]-prices[i]�������ᵼ��������������k
                    profit += prices[i+1]-prices[i];
                }
                i++;
            }
            return profit;
        }
        //sell_now[i][j]��ǰi�����j�ν����ҵ�i������������������
        int[][] sell_now = new int[n][k+1];
        //total[i][j]��ǰi�����j�ν��׵��������
        int[][] total = new int[n][k+1];
        
        for(int i=1; i<n; i++){
            for(int j=1; j<k+1; j++){
                int today_benifit = prices[i]-prices[i-1];
                //��i�������Ķ�Ӧ������/���ǵ�i-1��
                sell_now[i][j] = Math.max(total[i-1][j-1]+today_benifit, sell_now[i-1][j]+today_benifit);
                //���һ��������/���ǵ�i��
                total[i][j] = Math.max(sell_now[i][j], total[i-1][j]);
            }
        }
        
        return total[n-1][k];
    }
};
