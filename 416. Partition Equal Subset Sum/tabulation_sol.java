class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false; // odd sum can't be partitioned equally
        sum /= 2;

        boolean[][] dp = new boolean[n][sum + 1];

        // Base case: With sum = 0, it's always possible (empty subset)
        for (int i = 0; i < n; i++) dp[i][0] = true;

        // Base case: Only first element
        if (nums[0] <= sum) dp[0][nums[0]] = true;

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= sum; k++) {
                boolean notTake = dp[i - 1][k];
                boolean take = false;
                if (k >= nums[i]) take = dp[i - 1][k - nums[i]];

                dp[i][k] = take || notTake;
            }
        }

        return dp[n - 1][sum];
    }
}
