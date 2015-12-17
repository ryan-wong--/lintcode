public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] B = new int[2];
        B[0] = -1;
        B[1] = -1;
        if(A.length==0||A==null){
            return B;
        }
        
        int left, right, start, end, mid;
        start = 0;
        end = A.length-1;
        if(target<A[start]||target>A[end]){
            return B;
        }
        if(target==A[start])
            B[0] = start;
        if(target==A[end])
            B[1] = end;
        if(target==A[start] && target==A[end])
            return B;
        //找起始位置，即左边缘
        while(start+1<end){
            mid = start+(end-start)/2;
            if(A[mid]>=target)
                end = mid;
            else
                start = mid;
        }
        if(B[0]!=0)
            B[0] = end;
        if(A[end]!=target && A[start]!=target){
             B[0] = -1;
             B[1] = -1;
             return B;
        }
        //找结束位置，即右边缘
        start = 0;
        end = A.length-1;
        while(start+1<end){
            mid = start+(end-start)/2;
            if(A[mid]>target)
                end = mid;
            else
                start = mid;
        }
        if(B[1]!=A.length-1)
            B[1] = start;
        if(A[end]!=target && A[start]!=target){
             B[0] = -1;
             B[1] = -1;
             return B;
        }
        
        return B;
    }
}

