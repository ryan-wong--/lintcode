public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     * 给出字符串S和字符串T，计算S的不同的子序列中T出现的个数。
     * 给出S = "rabbbit", T = "rabbit", 返回 3
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
        
        /*  画图以便理解！！！！！！！！
            状态：建立int f[m][n],其中f[i][j]代表S的0~i子串中T的0~j子串出现的个数
            递推：f[i][j] = f[i-1][j] + f[i-1][j-1];（S下标i的字符与T下标j的字符相等时，
                表明f值会且只会在这里发生增加，这两项分别对应S[i]不参与/参与包含）
                或 f[i][j] = f[i-1][j];（S下标i的字符与T下标j的字符不等时，很好理解，
                这时S[i]的加入并不会导致T[0~j]的被包含数目增加）
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
