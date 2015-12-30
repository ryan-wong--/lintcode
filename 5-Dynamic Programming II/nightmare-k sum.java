public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        int n = A.length;
        int i, select, sum;//i:n, select:k, sum:target
        int floor;
        //f[i][select][sum]��Ϊ��������ǰi����ѡ��select��֮��Ϊsum�ķ�����
        int[][][] f = new int[n+1][k+1][target+1];
        
        //1.����ÿ��i��select=1������赥��������Ϊ��ʼ��
        //2.���ڵ�ǰ��i���µķ���Ҫô��ҪA[i-1]��Ҫô����Ҫ��������������������Ϳ�����
        for(i=1; i<=n; i++){
            for(select=1; select<=k; select++){
                for(sum=1; sum<=target; sum++){
                    floor = Math.max(0, sum-A[i-1]);
                    if(select==1){
                        if(f[i-1][select][sum]==1 || A[i-1]==sum)
                            f[i][select][sum] = 1;
                    }
                    else
                        f[i][select][sum] = f[i-1][select-1][floor] + f[i-1][select][sum];
                }
            }
        }
        return f[n][k][target];
    }
}

