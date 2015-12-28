public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*",
     * '.'ƥ������һ����ĸ��
     * '*'ƥ��������߶��ǰ���Ԫ�ء�
     * @return: A boolean
     */
    private static boolean equal_null(String p){
		 int lenp = p.length();
		 if(lenp%2 == 0){
			 for(int i=0; i<lenp-1; i+=2){
				 if(p.charAt(i+1)!='*'){
					 return false;
				 }
			 }
			 return true;
		 }
		 return false;
	}
	 
    public static boolean isMatch(String s, String p) {
		 int lens = s.length(), lenp = p.length();
		 char p1;
		 if(p.equals(".*")){
			 return true;
		 }
		 else if(lens == 0){
			 if(lenp == 0 || equal_null(p)){
				 return true;
			 }
			 else {
				 return false;
			 }
		 }
		 else if(lenp == 0){
			 return false;
		 }
		 
		 //ע��ģ���ַ���pȡ�����ڶ���Ԫ�ص��������p1����
		 if(lenp<=1){
			 p1 = ' ';
		 }
		 else{
			 p1 = p.charAt(1);
		 }
		 if(p1 == '*'){
		     //p1��*���������֧��1.pͷ�����ܺ�sͷһ����Ӧ�ϣ�2.��Ӧ����
		     //�Բߣ�1.a.����p��ͷ�������ŵݹ顢b.����sͷһ�����ŵݹ�
		     //         ���������Ժϲ�Ϊ������p��ͷ������sͷһ�����ŵݹ顱��
		     //         �����Ͱ�����ݹ��֧ʡȥ�ˣ�����һ����֧������Ч��
		     //     2.����p��ͷ�������ŵݹ飨��Ϊ���������pͷ�������Ե��ڿմ���
			 if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
				 return (isMatch(s, p.substring(2)) || isMatch(s.substring(1), p));
			 }
			 else{
				 return isMatch(s, p.substring(2));
			 }
		 }
		 else{//p1����*�������ֻ�ÿ�p��s�ĵ�һ���ܲ��ܶ��Ͼ�����
			 if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
				 return isMatch(s.substring(1), p.substring(1));
			 }
			 else{
				 return false;
			 }
		 }
		 //return false;
	 }
	 
}