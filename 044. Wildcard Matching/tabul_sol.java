class Solution {

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0]=true;
        int j=1;
        while(j<m+1){
            if(p.charAt(j-1)!='*') break;
            dp[0][j]=true;
            j++;
        }

        for (int i = 1; i <= n; i++) {
            for ( j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
}
