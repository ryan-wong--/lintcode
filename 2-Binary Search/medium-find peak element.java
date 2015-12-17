class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A.length==0||A==null)
            return 0;
        
        int start, mid, end;
        start = 0;
        end = A.length - 1;
        //只需比较mid点在两端的增减情况即可
        while(start+1<end)
        {
            mid = start+(end-start)/2;
            if(A[mid]<A[mid+1]){
                start = mid;
            }
            else if(A[mid]<A[mid-1]){
                end = mid;
            }
            else{
                return mid;
            }
        }
        
        if(A[start]>A[end])
            return start;
        else 
            return end;
    }
}

