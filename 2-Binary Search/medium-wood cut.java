public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L.length==0||L==null)
            return 0;
        if(L.length==1)
            return L[0]/k;
        
        int start, mid, end, max = 0;
        int i = 0;
        for(; i<L.length; i++)
            max = Math.max(max, L[i]);
        //以“切出来的小段木材长度”、“切出来的段数”分别为横、纵坐标，则明显是一个单调递减的离散函数（从(1, 总长度数)到(最长段长度, 1)），
        //我们要找到的是“使得y=k的最大x”，即y的序列中，"k"的位置的右边界。
        //设定横坐标定义域
        start = 1;
        end = max;
        if(num_pieces(L, end)==k)
            return end;
        
        //遍历纵坐标（以num_pieces求得），缩小横坐标范围
        while(start+1<end){
            mid = start + (end-start)/2;
            if(num_pieces(L, mid) >= k)
                start = mid;
            else 
                end = mid;
        }
        if(num_pieces(L, end)>=k)
            return end;
        else if(num_pieces(L, start)>=k)
            return start;
        else
            return 0;
    }
    
    /** 
     *@param log: length of the current piece of wood
     *return: the num of pieces that cut with @param log.
     */
    private int num_pieces(int[] L, int log){
        int i = 0, size = L.length-1, num = 0;
        for(; i<=size; i++){
            num += L[i]/log;
        }
        return num;
    }
}
