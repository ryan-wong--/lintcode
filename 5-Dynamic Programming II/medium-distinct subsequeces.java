public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     * �����ַ���S���ַ���T������S�Ĳ�ͬ����������T���ֵĸ�����
     * ����S = "rabbbit", T = "rabbit", ���� 3
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int i, j, limit, m = S.length(), n = T.length();
        int[][] f = new int[m][n];
        
        if(m<n||m<=0||n<=0){
            return 0;
        }
        if(S.charAt(0)==T.charAt(0)){
            f[0][0] = 1;
        }
        else{
            f[0][0] = 0;
        }
        
        /*  ��ͼ�Ա���⣡��������������
            ״̬������int f[m][n],����f[i][j]����S��0~i�Ӵ���T��0~j�Ӵ����ֵĸ���
            ���ƣ�f[i][j] = f[i-1][j] + f[i-1][j-1];��S�±�i���ַ���T�±�j���ַ����ʱ��
                ����fֵ����ֻ�������﷢�����ӣ�������ֱ��ӦS[i]������/���������
                �� f[i][j] = f[i-1][j];��S�±�i���ַ���T�±�j���ַ�����ʱ���ܺ���⣬
                ��ʱS[i]�ļ��벢���ᵼ��T[0~j]�ı�������Ŀ���ӣ�
        */
        for(i=1; i<m; i++){
            limit = Math.min(i, n-1);
            if(S.charAt(i)==T.charAt(0)){
                f[i][0] = f[i-1][0] + 1;
            }
            else{
                f[i][0] = f[i-1][0];
            }
            for(j=1; j<=limit; j++){
                if(S.charAt(i)==T.charAt(j)){
                    f[i][j] = f[i-1][j] + f[i-1][j-1];
                }
                else{
                    f[i][j] = f[i-1][j];
                }
            }
        }
        
        return f[m-1][n-1];
    }
}
