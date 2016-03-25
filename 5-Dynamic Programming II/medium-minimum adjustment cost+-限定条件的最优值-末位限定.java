public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     * ��һ���������飬����ÿ�����Ĵ�С��ʹ�����ڵ��������Ĳ�С��һ������������target��
     * ����ÿ�����Ĵ���Ϊ����ǰ��Ĳ�ľ���ֵ�����������֮����С�Ƕ��١�
     * ע�⣺ÿ��������1~100��������
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int cel, floor, min_, adjust, n = A.size(), val = 100;
        if(n<=1){
            return 0;
        }
        //f[i][j]�Ǽ��㵽A[i]֮�����һ��������Ϊj����С��������
        int[][] f = new int[n][val+1];
        for(int i=1; i<=val; i++){
            f[0][i] = Math.abs(A.get(0)-i);
        }
        //����֤������A[]ǰi��Ԫ�ص���������Сʱ����ôǰi-1��Ԫ�ص�������Ҳ����С��
        //����ʽf[i][j] = min(k){f[i-1][k] + |A(i)-j|}, j-target<=k<=j+target.
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