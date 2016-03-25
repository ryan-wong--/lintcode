public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     * 找出一个由0和1组成的矩阵里面最大的只包含“1”的正方形，输出它的的面积
     */
    public static int maxSquare(int[][] matrix) {
        // write your code here
        int row = matrix.length;
        int col = matrix[0].length;
        
        if(row<=0||col<=0){
            return 0;
        }
        
        //f[i][j]的含义：以matrix[i][j]为右下角的矩形的边长
        int[][] f = new int[row][col];
        for(int i=0; i<row; i++){
        	if(matrix[i][0]==1){
        		f[i][0] = 1;
        	}
        }
        for(int i=0; i<col; i++){
        	if(matrix[0][i]==1){
        		f[0][i] = 1;
        	}
        }
        
        for(int i=1; i<row; i++){
        	for(int j=1; j<col; j++){
        	    //递推式非常简单，就是当matrix[i][j]为1的时候，
        	    //f[i][j] = 1+min{f[i-1][j], f[i][j-1], f[i][j]}
        		if(matrix[i][j]==1){
	        		f[i][j] = Math.min(f[i-1][j], f[i][j-1]);
	        		//加剪枝，因为f[i-1][j-1] = max{f[i-1][j]-1, f[i][j-1]-1}
	        		//当仅当f[i-1][j]==f[i][j-1]时需要讨论f[i-1][j-1]
	        		if(f[i-1][j]==f[i][j-1]){
	        		    f[i][j] = Math.min(f[i][j], f[i-1][j-1]);
	        		}
	        		f[i][j] += 1;
        		}
        	}
        }
        
        int max_ = 0;
        for(int i=0; i<row; i++){
        	for(int j=0; j<col; j++){
        		max_ = Math.max(max_, f[i][j]);
        	}
        };
        
        return max_*max_;
    }
}