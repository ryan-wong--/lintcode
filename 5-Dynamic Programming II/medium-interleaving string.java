public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     * ���� s1 = "aabcc" s2 = "dbbca"
     * �� s3 = "aadbbcbcac"������  true.
     * �� s3 = "aadbbbaccc"�� ���� false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int m = s1.length(), n = s2.length(), len = s3.length();
        if(len!=m+n){
            return false;
        }
        else if(m==0){
            if(s2.equals(s3)){
                return true;
            }
            return false;
        }
        else if(n==0){
            if(s1.equals(s3)){
                return true;
            }
            return false;
        }
        //f[i][j]��ʾs1ǰi��Ԫ�غ�s2ǰj��Ԫ���ܷ񽻲湹��s3��ǰi+j��Ԫ�أ��ǵĻ�Ϊ1������Ϊ0
        int[][] f = new int[m+1][n+1];
        int sign = 1;
        for(int i=1; i<=m; i++){
            if(s1.charAt(i-1)==s3.charAt(i-1) && sign==1){
                f[i][0] = 1;
            }
            else{
                sign = 0;
            }
        }
        sign = 1;
        for(int i=1; i<=n; i++){
            if(s2.charAt(i-1)==s3.charAt(i-1) && sign==1){
                f[0][i] = 1;
            }
            else{
                sign = 0;
            }
        }
        
        //���ƹ�ϵ����s3�ĵ�i+j��Ԫ�غ�s1�ĵ�i��Ԫ�ػ���s2�ĵ�j��Ԫ���Ƿ���ȣ�
        //�������ȣ���f[i][j]Ϊ0
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s3.charAt(i+j-1)==s1.charAt(i-1) && s3.charAt(i+j-1)==s2.charAt(j-1)){
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                }
                else if(s3.charAt(i+j-1)==s1.charAt(i-1)){
                    f[i][j] = f[i-1][j];
                }
                else if(s3.charAt(i+j-1)==s2.charAt(j-1)){
                    f[i][j] = f[i][j-1];
                }
                else{
                    f[i][j] = 0;
                }
            }
        }
        
        return f[m][n]==1?true:false;
    }
}
