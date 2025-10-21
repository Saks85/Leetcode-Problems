class Solution {
    private int f(int ind, int buy, int cap, int[] prices, int[][][] dp) {
        if (ind == prices.length || cap == 0) return 0;
        if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        int profit;
        if (buy == 1) {
            profit = Math.max(
                -prices[ind] + f(ind + 1, 0, cap, prices, dp),
                f(ind + 1, 1, cap, prices, dp)
            );
        } else {
            profit = Math.max(
                prices[ind] + f(ind + 1, 1, cap - 1, prices, dp),
                f(ind + 1, 0, cap, prices, dp)
            );
        }
        return dp[ind][buy][cap] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k+1]; // ind, buy, cap

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0, 1, k, prices, dp);
    }
}
