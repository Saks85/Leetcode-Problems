class Solution {
    private int f(int[] nums, int ind, int target, int[][] dp) {
        // Base case
        if (ind == 0) {
            if (target == 0 && nums[0] == 0) return 2; // take or not take
            if (target == 0 || target == nums[0]) return 1;
            return 0;
        }

        if (dp[ind][target] != -1) return dp[ind][target];

        int notTake = f(nums, ind - 1, target, dp);
        int take = 0;
        if (nums[ind] <= target) {
            take = f(nums, ind - 1, target - nums[ind], dp);
        }

        return dp[ind][target] = notTake + take;
    }

    public int findTargetSumWays(int[] nums, int d) {
        int n = nums.length;
        
        // Calculate total sum
        int sum = 0;
        for (int num : nums) sum += num;

        // Validate target
        if (d > sum || d<-sum ||  (sum + d) % 2 != 0) return 0;

        int target = (sum + d) / 2;
        if (target<0) target=-target;
        
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return f(nums, n - 1, target, dp);
    }
}
