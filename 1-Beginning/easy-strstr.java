class Solution {
public:
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    int strStr(const char *source, const char *target) {
        int i;
        int j;
        int sign;
        //v = source;
        if(!source||!target)
            return -1;
        int len_s = strlen(source);
        int len_t = strlen(target);
        if(len_t==0)
            return 0;
        for(i=0; i<len_s-len_t; i++)
        {
            sign = 0;
            for(j=0; j<len_t; j++)
            {
                if(*(source+i+j) != *(target+j))
                    break;
                else
                    sign++;
                if(sign==len_t)
                    return 1;
            }
        }
        return -1;
        
    }
};