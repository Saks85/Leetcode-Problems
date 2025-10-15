class Solution {
    private int lcs(int i1, int i2, String s1, String s2, int [][] dp){
        //lowest comm subseq
        if (i1<0 || i2<0) return 0;
        if (dp[i1][i2]!=-1) return dp[i1][i2];

        if (s1.charAt(i1)==s2.charAt(i2)) return dp[i1][i2]= 1+ lcs(i1-1, i2-1,s1,s2,dp);
        return dp[i1][i2]= Math.max(lcs(i1-1,i2,s1,s2,dp),lcs(i1,i2-1,s1,s2,dp));

    }
    public int minInsertions(String s) {
        int n=s.length();
        String s2= new StringBuilder(s).reverse().toString();

        int [][] dp= new int [n+1][n+1];

        for (int i=0; i<n; i++) Arrays.fill(dp[i],-1);

        return n-lcs(n-1,n-1,s,s2,dp);
    }
}
