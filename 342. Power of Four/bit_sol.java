class Solution {
    public boolean isPowerOfFour(int n) {
        if(!((n &(n-1))==0)) return false; //power of 4 is also power of 4
        if((n&1)==1) return true;
        while (n>0){
            n=n>>2;
            if((n&1)==1) return true;
        }
        return false;
    }
}
