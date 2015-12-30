public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * 子串的字符应该连续的出现在原字符串中，这与子序列有所不同。
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int i, j, len, m = A.length(), n = B.length();
        int[][] f = new int[m+1][n+1];
        int[][] g = new int[m+1][n+1];//g[i][j]表示A[i-1]与B[i-1]是否相同
        
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
                    //len表示从尾部开始数，两string的连续完全相同部分的长度
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

//解法2：
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int i, j, len, m = A.length(), n = B.length();
        //f[i][j]表示若当前substring以A的第i个元素与B的第j个元素结尾时，它的长度
        //最后只需求出所有f[i][j]的最大值
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
