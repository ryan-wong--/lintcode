public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     * 给出编码规则：a→1、b→2、c→3、......、z→26
     * 输入一个全为数字的字符串，输出译码的总方案数，比如 12 可以翻译为 ab 也可以翻译为 l
     */
    public int numDecodings(String s) {
        // Write your code here
        //难点在于对'0'的处理，当s含有以下情况时候可以直接返回0（无法解码）
        //1.'0'或者'3'~'9'后面接'0'，2.第一个就是'0'
        int size = s.length();
        if(size == 0){
            return 0;
        }
        else if(s.charAt(0) == '0'){
            return 0;
        }
        else if(size == 1){
            return 1;
        }
        
        int[] f = new int[size];//f[i]表示s[i]的解码方案数
        f[0] = 1;
        if(s.charAt(0)>='3' && s.charAt(1)=='0'){
            return 0;
        }
        else if(s.charAt(0)=='1' && s.charAt(1)!='0'){
            f[1] = 2;
        }
        else if(s.charAt(0)=='2'){
            if(s.charAt(1)>'6' || s.charAt(1)=='0')
                f[1] = 1;
            else
                f[1] = 2;
        }
        else{
            f[1] = 1;
        }
        
        
        for(int i=2; i<size; i++){
            if(s.charAt(i)=='0' && (s.charAt(i-1)=='0' || s.charAt(i-1)>='3')){
                return 0;
            }
            
            if(s.charAt(i)=='0'){//末尾为'10'、'20',当仅当这种情况出现时后两位拆不开
                f[i] = f[i-2];
            }
            else if((s.charAt(i-1)=='1') || (s.charAt(i-1)=='2' && s.charAt(i)<='6')){//'11'~'19' & '21'~'26'，后两位可拆可不拆
                f[i] = f[i-1] + f[i-2];
            }
            else{
                f[i] = f[i-1];
            }
        }
        
        return f[size-1];
    }
}