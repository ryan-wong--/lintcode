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
        //���ϵ�O(n^2)TLE
        //�����O(n^1.5)AC
        
        // ��С������������a
        for(int a=0; a<=n; a++){
            // ��С������ƽ����b��b
            for(int b=0; a+b*b<=n; b++){
                // ��Ϊa+b*b���ܱ������ƽ��������������Ҫȡ�����н�С��
                f[a + b*b] = Math.min(f[a] + 1, f[a + b*b]);
            }
        }
        return f[n];
    }
}