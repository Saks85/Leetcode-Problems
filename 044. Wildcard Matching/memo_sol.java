class Solution {
    private boolean f(int i, int j, String s, String p, int[][] dp) {
        if (j < 0)
            return i < 0;

        if (i < 0) {
            for (int x = 0; x <= j; x++)
                if (p.charAt(x) != '*')
                    return false;
            return true;
        }

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean ans = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            ans = f(i - 1, j - 1, s, p, dp);
        else if (p.charAt(j) == '*')
            ans = f(i, j - 1, s, p, dp) || f(i - 1, j, s, p, dp);
        else
            ans = false;

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return f(n - 1, m - 1, s, p, dp);
    }
}
