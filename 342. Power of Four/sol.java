class Solution {
    public boolean isPowerOfFour(int n) {
        double s=n;
        while (s>3){
            s/=4;
        }
        return (s==1);
        
    }
}
