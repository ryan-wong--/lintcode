public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * �Ӵ����ַ�Ӧ�������ĳ�����ԭ�ַ����У�����������������ͬ��
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int i, j, len, m = A.length(), n = B.length();
        int[][] f = new int[m+1][n+1];
        int[][] g = new int[m+1][n+1];//g[i][j]��ʾA[i-1]��B[i-1]�Ƿ���ͬ
        
        if(m<=0||n<=0){
            return 0;
        }
       
        for(i=0; i<=m; i++){
            f[i][0] = 0;
        }
        for(j=1; j<=n; j++){
            f[0][j] = 0;
        }
        
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                g[i][j] = 0;
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                if(A.charAt(i-1)==B.charAt(j-1)){
                    g[i][j] = 1;
                    //len��ʾ��β����ʼ������string��������ȫ��ͬ���ֵĳ���
                    len = 1;
                    while(g[i-len][j-len]==1){
                        len++;
                    }
                    
                    f[i][j] = Math.max(f[i][j], len);
                }
            }
        }
        
        return f[m][n];
    }
}

//�ⷨ2��
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int i, j, len, m = A.length(), n = B.length();
        //f[i][j]��ʾ����ǰsubstring��A�ĵ�i��Ԫ����B�ĵ�j��Ԫ�ؽ�βʱ�����ĳ���
        //���ֻ���������f[i][j]�����ֵ
        int[][] f = new int[m+1][n+1];
        int max_ = 0;
        
        if(m<=0||n<=0){
            return 0;
        }
       
        for(i=0; i<=m; i++){
            f[i][0] = 0;
        }
        for(j=1; j<=n; j++){
            f[0][j] = 0;
        }
        
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    f[i][j] = 1+f[i-1][j-1];
                }
                max_ = Math.max(max_, f[i][j]);
            }
        }
        
        return max_;
    }
    
}
