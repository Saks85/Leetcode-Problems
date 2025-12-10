class Solution {
    public int countPermutations(int[] complexity) {
        int c= complexity[0];
        long ans= 1;
        int mod=(int )(1e9+7);
        for ( int i=1; i< complexity.length; i++){
            if ( complexity[i]<=c) return 0;
            ans= (ans*i)%mod; // calculting factorial and taking mod
        }
        return (int)ans;
    }
}
