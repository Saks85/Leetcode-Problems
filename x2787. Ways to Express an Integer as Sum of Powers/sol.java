class Solution {
    public int numberOfWays(int n, int x) {
        final int MOD = 1000000007;

        // Step 1: Generate all powers i^x that are <= n
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        int i = 1;
        while (true) {
            long power = (long) Math.pow(i, x); // use long to avoid overflow
            if (power > n) break;
            powers.add((int) power);
            i++;
        }

        // Step 2: Initialize DP array
        // dp[s] = number of ways to make sum s using the processed powers
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to make sum 0 — pick nothing

        // Step 3: Process each power like an item in 0/1 knapsack
        for (int p : powers) {
            for (int sum = n; sum >= p; sum--) {
                dp[sum] = (dp[sum] + dp[sum - p]) % MOD;
            }
        }

        // Step 4: Answer is ways to make sum n
        return dp[n];
    }
}
