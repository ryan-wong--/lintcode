public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     * �����������a��1��b��2��c��3��......��z��26
     * ����һ��ȫΪ���ֵ��ַ��������������ܷ����������� 12 ���Է���Ϊ ab Ҳ���Է���Ϊ l
     */
    public int numDecodings(String s) {
        // Write your code here
        //�ѵ����ڶ�'0'�Ĵ�����s�����������ʱ�����ֱ�ӷ���0���޷����룩
        //1.'0'����'3'~'9'�����'0'��2.��һ������'0'
        int size = s.length();
        if(size == 0){
            return 0;
        }
        else if(s.charAt(0) == '0'){
            return 0;
        }
        else if(size == 1){
            return 1;
        }
        
        int[] f = new int[size];//f[i]��ʾs[i]�Ľ��뷽����
        f[0] = 1;
        if(s.charAt(0)>='3' && s.charAt(1)=='0'){
            return 0;
        }
        else if(s.charAt(0)=='1' && s.charAt(1)!='0'){
            f[1] = 2;
        }
        else if(s.charAt(0)=='2'){
            if(s.charAt(1)>'6' || s.charAt(1)=='0')
                f[1] = 1;
            else
                f[1] = 2;
        }
        else{
            f[1] = 1;
        }
        
        
        for(int i=2; i<size; i++){
            if(s.charAt(i)=='0' && (s.charAt(i-1)=='0' || s.charAt(i-1)>='3')){
                return 0;
            }
            
            if(s.charAt(i)=='0'){//ĩβΪ'10'��'20',�����������������ʱ����λ�𲻿�
                f[i] = f[i-2];
            }
            else if((s.charAt(i-1)=='1') || (s.charAt(i-1)=='2' && s.charAt(i)<='6')){//'11'~'19' & '21'~'26'������λ�ɲ�ɲ���
                f[i] = f[i-1] + f[i-2];
            }
            else{
                f[i] = f[i-1];
            }
        }
        
        return f[size-1];
    }
}