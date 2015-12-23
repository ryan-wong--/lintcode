public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int size = A.length;
        int[] f = new int[size];
        int[] count = new int[size];
        f[0] = 1;
        count[0] = 0;
        int i, j, min_;
        
        for(i=1; i<size; i++){
            f[i] = 0;
            min_ = size;
            for(j=i-1; j>=0; j--){
                if(f[j]==1 && A[j]>=i-j){//第二层循环中用一个整型变量min_不断刷最少跳跃次数
                    f[i] = 1;
                    min_ = Math.min(min_, count[j]+1);
                }
            }
            count[i] = min_;
        }
        
        if(f[size-1] == 1){
            return count[size-1];
        }
        return 0;
    }
}

