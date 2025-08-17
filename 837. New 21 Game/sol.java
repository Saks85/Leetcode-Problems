class Solution {
  //dp + sliding window
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k - 1 + maxPts) {
            return 1.0; // Alice cannot lose in these cases
        }

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0; // sum of last maxPts probabilities
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            if (i < k) {
                // Still drawing, so include dp[i] in the sliding window
                windowSum += dp[i];
            } else {
                // Alice stops drawing, add probability to result
                result += dp[i];
            }

            // Remove the oldest probability when window exceeds maxPts
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return result;
    }
}
