public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     * 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　
     * 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　
     * 判断你是否能到达数组的最后一个位置。
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int size = A.length;
        int[] f = new int[size];
        f[0] = 1;
        int i, j;
        
        for(i=1; i<size; i++){
            f[i] = 0;
            for(j=i-1; j>=0; j--){//动态规划法没什么难的，循环套循环
                if(f[j]==1 && A[j]>=i-j){
                    f[i] = 1;
                }
            }
        }
        
        if(f[size-1] == 1){
            return true;
        }
        return false;
    }
}

