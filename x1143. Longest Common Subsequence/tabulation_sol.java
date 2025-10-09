class Solution {
    private int f(int i1, int i2, String s1, String s2, int[][] dp) {
        if (i1 < 0 || i2 < 0)
            return 0;
        if (dp[i1][i2] != -1)
            return dp[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = 1 + f(i1 - 1, i2 - 1, s1, s2, dp);
        return dp[i1][i2] = Math.max(f(i1 - 1, i2, s1, s2, dp), f(i1, i2 - 1, s1, s2, dp));

    }

    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int [][] dp= new int [n+1][m+1];

        for (int i=0; i<=n; i++) dp[i][0]=0;
        for (int j=0; j<=m; j++) dp[0][j]=0;

        for (int i=1; i<=n ;i++){
            for (int j=1; j<=m; j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)) 
                dp[i][j]= 1+ dp[i-1][j-1];
                else
                dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return f(n,m,s1,s2,dp);
        
    }
}
