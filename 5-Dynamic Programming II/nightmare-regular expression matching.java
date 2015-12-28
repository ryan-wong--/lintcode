public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*",
     * '.'匹配任意一个字母。
     * '*'匹配零个或者多个前面的元素。
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
		 
		 //注意模板字符串p取不到第二个元素的情况，用p1代替
		 if(lenp<=1){
			 p1 = ' ';
		 }
		 else{
			 p1 = p.charAt(1);
		 }
		 if(p1 == '*'){
		     //p1是*的情况，分支：1.p头两个能和s头一个对应上，2.对应不上
		     //对策：1.a.舍弃p的头两个接着递归、b.舍弃s头一个接着递归
		     //         这两步可以合并为“舍弃p的头两个与s头一个接着递归”，
		     //         这样就把这个递归分支省去了，减少一个分支大大提高效率
		     //     2.舍弃p的头两个接着递归（因为这种情况下p头两个可以等于空串）
			 if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'){
				 return (isMatch(s, p.substring(2)) || isMatch(s.substring(1), p));
			 }
			 else{
				 return isMatch(s, p.substring(2));
			 }
		 }
		 else{//p1不是*的情况，只用看p和s的第一个能不能对上就行了
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