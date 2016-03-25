public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     * 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。
     * 插入、删除、替换
     */
    private int min_(int a, int b, int c){
        int temp;
        temp = Math.min(a, b);
        temp = Math.min(temp, c);
        return temp;
    }
    public int minDistance(String word1, String word2) {
        // write your code here
        int i, j, m, n;
        m = word1.length();
        n = word2.length();
        int[][] f = new int[m+1][n+1];
        for(i=0; i<=m; i++){
            f[i][0] = i;
        }
        for(j=0; j<=n; j++){
            f[0][j] = j;
        }
        
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    f[i][j] = min_(f[i-1][j]+1, f[i][j-1]+1, f[i-1][j-1]+1);
                }
                else{
                    f[i][j] = f[i-1][j-1];
                }
            }
        }
        
        return f[m][n];
    }
}
