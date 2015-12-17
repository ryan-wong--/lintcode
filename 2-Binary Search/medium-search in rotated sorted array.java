public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A.length==0||A==null)
            return -1;
        
        int start, mid, end;
        start = 0;
        end = A.length-1;
        
        if(A[start]<A[end]){//当该数组严格递增时
            while(start+1<end){
                mid = start+(end-start)/2;
                if(A[mid]>target){
                    end = mid;
                }
                else if(A[mid]<target){
                    start = mid;
                }
                else
                    return mid;
            }
        }
        else if(target >= A[start]){//以下两种情况，画数组的递增趋势图就明白了
            while(start+1<end){
                mid = start+(end-start)/2;
                if(A[mid]<A[A.length-1]||A[mid]>target){
                    end = mid;
                }
                else if(A[mid]<target && A[mid]>A[start]){
                    start = mid;
                }
                else if(A[mid]==target)
                    return mid;
            }
        }
        else{
            while(start+1<end){
                mid = start+(end-start)/2;
                if(A[mid]>target && A[mid]<A[A.length-1]){
                    end = mid;
                }
                else if(A[mid]>A[0]||A[mid]<target){
                    start = mid;
                }
                else if(A[mid]==target)
                    return mid;
            }
        }
        
        if(A[start]==target)
            return start;
        else if(A[end]==target)
            return end;
        else
            return -1;
    }
}

