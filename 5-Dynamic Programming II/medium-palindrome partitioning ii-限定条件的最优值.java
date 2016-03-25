public class Solution {
    /**
     * @param s a string
     * @return an integer
     * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文。返回s符合要求的的最少分割次数。
     * 比如，给出字符串s = "aab"，返回 1， 因为进行一次分割可以将字符串s分割成["aa","b"]这样两个回文子串
     */
    private boolean is_palindrome(String sub){//O(len)
        int i, len = sub.length();
        for(i=0; i<len/2; i++){
            if(sub.charAt(i)!=sub.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
    public int minCut(String s) {
        // write your code here
        int i, j, min_, size = s.length();
        int[] f = new int[size];
        f[0] = 0;
        
        if(size==1){
            return f[size-1];
        }
        for(i=1; i<size; i++){//对每个i遍历比它小的每个j，看j+1~i这一块是否回文
            if(is_palindrome(s.substring(0, i+1))){//注意不要漏了字符串长为i时的右边界！
                f[i] = 0;
                continue;
            }
            min_ = size-1;
            for(j=0; j<i; j++){
                if(is_palindrome(s.substring(j+1, i+1))){
                    min_ = Math.min(min_, f[j] + 1);
                }
                else{
                    min_ = Math.min(min_, f[j] + i - j);
                }
            }
            f[i] = min_;
        }
        return f[size-1];
    }
};
