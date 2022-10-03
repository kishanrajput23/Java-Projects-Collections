public class Solution {
    public int romanToInt(String A) {
        int ans=0;
        int i=0;
        while(i<A.length()){
            if(i+1<A.length()){
                if(getValue(A.charAt(i+1))>getValue(A.charAt(i))){
                    ans+=getValue(A.charAt(i+1))-getValue(A.charAt(i));
                    i+=2;
                }else{
                    ans+=getValue(A.charAt(i));
                    i++;
                }
            }else{
                ans+=getValue(A.charAt(i));
                i++;
            }
        }
        return ans;
    }
    int getValue(char ch){
        switch(ch){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }
}
