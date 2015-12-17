/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int start = 1, end = n, mid;
        
        if(n==1)
            return 1;
        
        if(SVNRepo.isBadVersion(1))
            return 1;
        while(start+1<end){
            mid = start+(end-start)/2;
            if(SVNRepo.isBadVersion(mid))
                end = mid;
            else 
                start = mid;
        }
        return end;
    }
}

