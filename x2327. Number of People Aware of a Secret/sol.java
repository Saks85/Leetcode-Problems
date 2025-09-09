class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1]; // dp[i] = people who learn the secret on day i
        dp[1] = 1; // Day 1, only 1 person knows the secret
        long sharing = 0; // total active sharers

        for (int day = 2; day <= n; day++) {
            // Add people who just became eligible to share
            if (day - delay >= 1) {
                sharing = (sharing + dp[day - delay]) % MOD;
            }
            // Remove people who just forgot the secret
            if (day - forget >= 1) {
                sharing = (sharing - dp[day - forget] + MOD) % MOD;
            }
            // People learning the secret today = all active sharers
            dp[day] = sharing;
        }

        // Count all people who still remember at day n
        long result = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            result = (result + dp[i]) % MOD;
        }

        return (int) result;
    }
}
