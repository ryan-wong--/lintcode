public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     * 算法导论15章的原题
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int i, j, count, m = A.length(), n = B.length();
        int[][] f = new int[m][n];
        
        if(m<=0||n<=0){
            return 0;
        }
        count = 0;
        for(i=0; i<m; i++){
            if(A.charAt(i)==B.charAt(0)){
                count = 1;
            }
            f[i][0] = count;
        }
        count = 0;
        for(j=1; j<n; j++){
            if(A.charAt(0)==B.charAt(j)){
                count = 1;
            }
            f[0][j] = count;
        }
        
        for(i=1; i<m; i++){
            for(j=1; j<n; j++){
                if(A.charAt(i)==B.charAt(j)){
                    f[i][j] = f[i-1][j-1] + 1;
                }
                else{
                    f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                }
            }
        }
        
        return f[m-1][n-1];
    }
}
