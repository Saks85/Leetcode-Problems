import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        Arrays.sort(cuts);
        for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];

        int[][] dp = new int[m + 2][m + 2];

        // length = number of cuts considered in this subproblem
        for (int len = 2; len <= m + 1; len++) {      // interval size
            for (int i = 0; i + len <= m + 1; i++) {  // left boundary
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = arr[j] - arr[i] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}
