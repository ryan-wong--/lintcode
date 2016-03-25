public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     * ��������һ��רҵ��������׼������һ���ִ�ٷ��ݡ�ÿ�����Ӷ�������ض�����Ǯ�������ٵ�ΨһԼ�������ǣ����ڵķ���װ���໥��ϵ�ķ���ϵͳ���� �����ڵ���������ͬһ�챻���ʱ����ϵͳ���Զ�������
     * ����һ���Ǹ������б���ʾÿ�������д�ŵ�Ǯ�� ��һ�㣬�������ȥ��٣��������Եõ�����Ǯ �ڲ���������װ�õ�����¡�
     */
    public long houseRobber(int[] A) {
        // write your code here
        int n = A.length;
        if(n==0){
            return 0;
        } else if(n==1){
            return A[0];
        } else if(n==2){
            return Math.max(A[0], A[1]);
        } else if(n==3){
            return Math.max(A[0]+A[2], A[1]);
        }
        
        long[] f = new long[n];//f[i]��ʾi�ŷ��ӱر�����ǰ���£����ٷ��������
        f[0] = A[0];
        f[1] = A[1];
        f[2] = A[0]+A[2];
        long max_ = Integer.MIN_VALUE;
        
        for(int i=3; i<n; i++){
            //��һ��������Ҫô��i-2Ҫô��i-3�������i-4�Ļ���ô�϶���������i-2�������Բ�������i-4���²���
            f[i] = Math.max(f[i-2], f[i-3]) + A[i];
        }
        return Math.max(f[n-2], f[n-1]);
    }
}