public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * ��������������������ӱ�Ϳ��ͬ��ɫ
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
        
        int[] same = new int[n];//��ʾ��ǰһ��������ͬɫʱ�Ļ�ͼ�ܷ�����
        int[] diff = new int[n];//��ʾ��ǰһ�����Ӳ�ͬɫʱ�Ļ�ͼ�ܷ�����
        
        same[1] = k;
        diff[1] = k*(k-1);
        
        for(int i=2; i<n; i++){
            same[i] = diff[i-1];
            diff[i] = (k-1)*(diff[i-1] + same[i-1]);//ֻҪi����i-1����һ���Ϳ���
        }
        
        return same[n-1] + diff[n-1];
        
    }
}