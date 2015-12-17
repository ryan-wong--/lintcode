public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num.length==0 || num==null){
            return -1;
        }
        if(num.length==1){
            return num[0];
        }
        
        int start, end, mid;
        start = 0;
        end = num.length-1;
        if(num[start]<num[end])
            return num[start];
        while(start+1 < end){
            mid = (start+end)/2;
            if(num[mid]>num[start])
                start = mid;
            else if(num[mid]<num[end])
                end = mid;
        }
        return num[end];
    }
}
