import java.util.*;

/**
 * NOTE: This is the Dynamic Programming solution for the problem.
 * It correctly tracks the number of elements used for each sum.
 * However, due to the potentially large number of unique sums,
 * this approach is too slow and memory-intensive for the given constraints
 * and will likely fail with a "Time Limit Exceeded" or "Memory Limit Exceeded" error.
 */
class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // dp[k] will store a set of all achievable sums using exactly k elements.
        // This is the most optimized version of the DP state for this problem.
        Set<Integer>[] dp = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashSet<>();
        }

        // Base case: A sum of 0 is achievable with 0 elements.
        dp[0].add(0);

        // Iterate through each number in the input array.
        for (int num : nums) {
            // We must iterate 'k' backwards. This ensures that when we calculate the sums
            // for 'k' elements, we are using the sums from the previous state (before
            // processing 'num') that used 'k-1' elements.
            for (int k = n; k >= 1; k--) {
                // For each sum that was possible with k-1 elements...
                for (int prevSum : dp[k - 1]) {
                    // ...we can now form a new sum with k elements by adding the current number.
                    dp[k].add(prevSum + num);
                }
            }
        }

        // After filling the DP table, find the minimum difference.
        // We only care about sums formed by exactly 'n' elements, which are in dp[n].
        int minDiff = Integer.MAX_VALUE;
        Set<Integer> partition1Sums = dp[n];

        for (int s1 : partition1Sums) {
            // The sum of the second partition is the remainder.
            int s2 = totalSum - s1;
            // The difference is |s1 - s2|, which is |s1 - (totalSum - s1)| = |2*s1 - totalSum|.
            minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * s1));
        }

        return minDiff;
    }
}
