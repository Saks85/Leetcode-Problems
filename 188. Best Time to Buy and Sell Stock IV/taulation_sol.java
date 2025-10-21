class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1]; // ind, buy, cap

        // Base Case: dp[n][*][*] = 0 and dp[*][*][0] = 0 automatically

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int profit;
                    if (buy == 1) {
                        // We can buy or skip
                        profit = Math.max(
                            -prices[ind] + dp[ind + 1][0][cap],  // buy
                            dp[ind + 1][1][cap]                 // skip
                        );
                    } else {
                        // We can sell or skip
                        profit = Math.max(
                            prices[ind] + dp[ind + 1][1][cap - 1], // sell → consume 1 transaction
                            dp[ind + 1][0][cap]                    // skip
                        );
                    }
                    dp[ind][buy][cap] = profit;
                }
            }
        }

        // Start at day 0, can buy, with 2 transactions remaining
        return dp[0][1][k];
    }
}
