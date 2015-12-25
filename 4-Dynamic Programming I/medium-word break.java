public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     * 给出一个字符串s和一个词典，判断字符串s是否可以被空格切分成一个或多个出现在字典中的单词。
     * 样例：给出s = "lintcode"、dict = ["lint","code"]，返回 true 因为"lintcode"可以被空格切分成"lint code"
     */
    private int max_length(Set<String> dict){
        int max_ = 0;
        for(String word:dict){
            max_ = Math.max(max_, word.length());
        }
        return max_;
    }
    private int min_length(Set<String> dict){
        int min_ = Integer.MAX_VALUE;
        for(String word:dict){
            min_ = Math.min(min_, word.length());
        }
        return min_;
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        int len = s.length();
        int max_l = max_length(dict), min_l = min_length(dict);
        int i, j, floor;
        String new_word;
        boolean[] f = new boolean[len+1];//若f[i]=true，则表示s到第i个字符的时候能被完美切割
        f[0] = true;
        
        //若对于小于当前s长度i的任意j（遍历j）：有f[j]=true，且j~i的子串在dict中，则f[i]=true
        for(i=1; i<=len; i++){
            f[i] = false;
            if(i<min_l){
                continue;
            }
            floor = Math.max(i-max_l, 0);
            for(j=i-min_l; j>=floor; j--){
                new_word = s.substring(j, i);
                //类似hashmap，Set可用contains方法确认元素是否在其中
                if(f[j]==true && dict.contains(new_word)){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[len];
    }
}
