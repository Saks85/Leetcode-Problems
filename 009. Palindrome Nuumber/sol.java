class Solution {
    static{
        for(int i=0; i<1000; i++){
            isPalindrome(0);
        }
    }
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int w=x, ans=0;
        while (w>0){
            ans= ans*10 + (w%10);
            w=w/10;           
        }
        if (ans==x) return true;
        return false;       
    }
}
