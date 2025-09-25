class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // sum = 0 is always possible

        for (int num : nums) {
            // Traverse backwards to avoid overwriting data we still need
            for (int k = sum; k >= num; k--) {
                dp[k] = dp[k] || dp[k - num];
            }
        }

        return dp[sum];
    }
}
