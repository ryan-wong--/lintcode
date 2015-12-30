public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int len = A.size(), min_;
        int val = 100;
        //f[i][j]ָ��iΪֹ���������飬���һ��������Ϊjʱ����С��������
        int[][] f = new int[len][101];
        if(len<=1){
            return 0;
        }
        
        for(int i=0; i<len; i++){
            f[i][0] = -1;
        }
        for(int j=1; j<=val; j++){
            f[0][j] = Math.abs(A.get(0)-j);
        }
        
        for(int i=1; i<len; i++){
            for(int j=1; j<=val; j++){
                //A[i]���j�Ĵ���
                int delta = Math.abs(A.get(i)-j);
                //��Ȼ��֪A[i]Ҫ���j����ôA[i-1]���Ѿ����ܱ䣩ֻ����j+-target֮��ѡ
                int cel = Math.min(j+target, val);
                int floor = Math.max(j-target, 1);
                
                f[i][j] = Integer.MAX_VALUE;
                for(int k=floor; k<=cel; k++){
                    //���ƣ�iֻ�迼��i-1�����
                    f[i][j] = Math.min(f[i][j], f[i-1][k]+delta);
                }
            }
        }
        min_ = Integer.MAX_VALUE;
        for(int j=1; j<=val; j++){
            min_ = Math.min(min_, f[len-1][j]);
        }
        return min_;
    }
}