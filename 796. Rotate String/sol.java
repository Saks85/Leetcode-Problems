class Solution {

  //practical way
/*    public boolean rotateString(String s, String goal) {
        if (s.length()!=goal.length()) return false;
        int len=s.length();
        char s1=s.charAt(0);
        for ( int i=0; i<len; i++){
            char g=goal.charAt(i);
            if (g==s1){
                    if (s.substring(0,len-i).equals(goal.substring(i,len))
                    && s.substring(len-i,len).equals(goal.substring(0,i))) return true;
            }

        } 
        return false;       
    }
    */


//Amazing and BEST method

public boolean rotateString(String s, String goal) {
       return ((s.length()==goal.length()) && (s+s).contains(goal)); 
    }
}


