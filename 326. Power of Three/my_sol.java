class Solution {
  //brute almost
    public boolean isPowerOfThree(int n) {
        int lim= (int) (Math.log(Integer.MAX_VALUE)/Math.log(3));
        //System.out.println(lim);
        for (int i=0; i<=lim; i++){
            //System.out.println(i+" "+Math.pow(3,i));
            if(n==Math.pow(3,i)) return true;
            if(n<Math.pow(3,i)) return false;
        }
        return false;                
    }
}
//simple change but improves the performance by a lot
//Math.pow func is slow and time taking
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

}
