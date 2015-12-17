public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A==null||A.length==0)
        {
            return 0;
        }
        
        int start = 0, end = A.length-1;
        int mid;
        if(target<=A[start])
            return start;
        else if(target==A[end])
            return end;
        else if(target>A[end])
            return end+1;    
        while(start+1<end)
        {
            mid = start+(end-start)/2;
            if(target==A[mid])
                return mid;
            else if(target<A[mid])
                end = mid;
            else if(target>A[mid])
                start = mid;
        }
        if(target==A[start])
            return start;
        else 
            return end;
    }
}

