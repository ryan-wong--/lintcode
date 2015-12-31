public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     * 给一个目标数 target, 一个非负整数 k, 一个按照升序排列的数组 A。在A中找与target最接近的k个整数。
     * 返回这k个数并按照与target的接近程度从小到大排序，如果接近程度相当，那么小的数排在前面。
     */
    //从最接近的点向两边搜索前k个最接近target的元素，注意当搜索触到A的边界的情况，要优先处理
    private int[] build_res(int[] A, int target, int k, int left, int right){
        int[] res = new int[k];
        int i=0;
        while(i<k){
            if(left<0){
                res[i] = A[right];
                right++;
                i++;
                continue;
            }
            else if(right>A.length-1){
                res[i] = A[left];
                left--;
                i++;
                continue;
            }
            if(A[right]-target>=target-A[left]){
                res[i] = A[left];
                left--;
                i++;
            }
            else{
                res[i] = A[right];
                right++;
                i++;
            }
        }
        
        return res;
    }
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int n = A.length;
        int[] res = new int[k];
        if(n<=0){
            return res;
        }
        //考虑极端情况，比如当target不在A的范围内的时候
        if(A[0]>target ){
            for(int i=0; i<k; i++){
                res[i] = A[i];
            }
            return res;
        }
        else if(A[n-1]<target){
            for(int i=0; i<k; i++){
                res[i] = A[n-i-1];
            }
            return res;
        }
        //二分法查找target最接近的点
        int start = 0, mid, end = n-1;
        while(start+1<end){
            mid = start+(end-start)/2;
            if(A[mid]<=target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        return build_res(A, target, k, start, end);
    }
}