package Lexicographic_String;

public class Lexicographic_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1="Komal";
        String s2="Kunal";
        //+ve s1>s2
        //-ve s2>s1
        //0 s1==s2
        System.out.println(compareTo(s1,s2));
	}
    public static int compareTo(String s1,String s2) {
    	if(s1==s2) {
    		return 0;
    	}
    	int length=Math.min(s1.length(), s2.length());
    	for(int i=0;i<length;i++) {
    		if(s1.charAt(i)!=s2.charAt(i)) {
    			return s1.charAt(i)-s2.charAt(i);
    		}
    	}
    	return s1.length()-s2.length();
    }
}
