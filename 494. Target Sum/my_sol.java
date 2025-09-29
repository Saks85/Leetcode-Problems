class Solution {
    private int f(int ind, int target, int[] nums, int[][] dp, int offset) {
        if (ind == 0) {
            if (target - nums[0] == offset && target + nums[0] == offset)
                return 2;
            if (target - nums[0] == offset || target + nums[0] == offset)
                return 1;
            return 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];
        int add = 0, sub = 0;
        if (target - nums[ind] >= 0)
            add = f(ind - 1, target - nums[ind], nums, dp, offset);
        if (target + nums[ind] < dp[ind].length)
            sub = f(ind - 1, target + nums[ind], nums, dp, offset);

        return dp[ind][target] = (add + sub);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int minSum = 0;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += nums[i];
            minSum -= nums[i];
        }
        if (target > maxSum || target < minSum)
            return 0;
        int offset = -minSum;
        int range = maxSum - minSum + 1;
        int dp[][] = new int[n][range];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return f(n - 1, target + offset, nums, dp, offset);

    }
}
