class Solution {
    private long nCr(int n, int r) {
        if (r > n - r) r = n - r;
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result *= (n - r + i);
            result /= i;
        }
        return result;
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        int ones = n, twos = 0;
        long ways = 0;

        // Try all possible counts of 2-steps
        while (ones >= twos) {
            ways += nCr(ones, twos);
            ones--;
            twos++;
        }
        return (int) ways;
    }
}
