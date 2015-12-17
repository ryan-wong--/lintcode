class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums.length==0 || nums==null)
            return -1;
        
        int start, mid, end;
        start = 0;
        end = nums.length-1;
        if(nums[start]==target)
            return 0;
        while(start+1 < end)
        {
            mid = (start+end)/2;
            if(nums[mid]>=target)
                end = mid;
            else if(nums[mid]<target)
                start = mid;
        }
        
        if(target==nums[end])
            return end;
        else
            return -1;
    }
}
