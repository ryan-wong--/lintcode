public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length==0||matrix==null)
        {
            return false;
        }
        
        int mid, start, end, last_end, t_row;
        start = 0;
        end = matrix.length-1;
        last_end = matrix[end].length-1;
        if(target<matrix[0][0] || target>matrix[end][last_end])
            return false;
        while(start+1<end){
            mid = (start+end)/2;
            if(target<matrix[mid][0])
                end = mid;
            else if(target>matrix[mid][0])
                start = mid;
            else 
                return true;
        }
        
        if(target<matrix[end][0])
            t_row = start;
        else
            t_row = end;
        
        start = 0;
        end = matrix[t_row].length-1;
        while(start+1<end){
            mid = (start+end)/2;
            if(target<matrix[t_row][mid])
                end = mid;
            else if(target>matrix[t_row][mid])
                start = mid;
            else 
                return true;
        }
        if(target==matrix[t_row][start]||target==matrix[t_row][end])
            return true;
        else
            return false;
    }
}

