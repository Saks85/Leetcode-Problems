class Solution {
    public int maximumEnergy(int[] energy, int k) {
         int n = energy.length;
        int ans = Integer.MIN_VALUE;

        // For each chain starting remainder r = 0 to k-1
        for (int r = 0; r < k; r++) {
            int sum = 0;
            int best = Integer.MIN_VALUE;

            // walk backward through the chain r + m*k <= n-1
            for (int idx = r + ((n - 1 - r) / k) * k; idx >= 0; idx -= k) {
                sum += energy[idx];
                // take the maximum suffix from this chain
                best = Math.max(best, sum);
            }

            ans = Math.max(ans, best);
        }

        return ans;
    }
}
