class Solution {
    public int getPow(long base, long exp){
        long mod = 1_000_000_007L; // integer literal, no cast, no floating-point
        long res=1;
        base%=mod;
        while (exp>0){
            if((exp &1)==1){//exp is odd
                res=(res*base)%mod;
                //control will come to this at the end as exp will be 1
                //and whenever we encounter an odd
                exp--;//redundant can be avoided as in next step exp/2 is done which will give same result even if exp-1 isn't done
            }
            base=(base*base)%mod; //the same logic used in pow(x,n)
            exp=exp/2;
        }
        return (int)res;
    }
    public int countGoodNumbers(long n) {
        //long mod=(long)(1e9 + 7); //this is treated a double so have to cast
        long mod = 1_000_000_007L; // integer literal, no cast, no floating-point

        long evenCount = (n + 1) / 2; // number of even positions
        long oddCount = n / 2;       // number of odd positions
        
        long part1 = getPow(5, evenCount); // 5 choices for even positions
        long part2 = getPow(4, oddCount);  // 4 choices for odd positions
        
        return (int)((part1 * part2) % mod);
        
    }
}
