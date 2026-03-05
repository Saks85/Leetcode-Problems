class Solution {
    public int findCount(String s, int prev){
        int lastInt= prev;
        int cnt=0;
        for (int i=0; i<s.length(); i++){
            int pres= s.charAt(i)-'0';
            if (pres==lastInt) {
                cnt++; 

            }
            lastInt=(lastInt==0)?1:0;
        }
        return cnt;
    }
    public int minOperations(String s) {
        return Math.min(findCount(s,0), findCount(s,1));
    }
}
