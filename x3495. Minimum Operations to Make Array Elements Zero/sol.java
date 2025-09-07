class Solution {
    public long minOperations(int[][] queries) {
        long total = 0;

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            // Compute operations for range [l, r]
            long ops = getOperations(r) - getOperations(l - 1);

            // Each operation affects 2 elements → round up when odd
            total += (ops + 1) / 2;
        }

        return total;
    }

    // Helper function: cumulative operation-units required for numbers 1 to n
    private long getOperations(long n) {
        if (n <= 0) return 0;

        long res = 0;     // Total cumulative operations
        long ops = 0;     // Operation count for current block
        long blockStart = 1; // Starting point for the current block

        while (blockStart <= n) {
            long blockEnd = Math.min(n, blockStart * 4 - 1); // [blockStart, blockEnd]
            ops++; // Each block needs one more operation step

            // Count how many numbers are in this block and multiply by the ops needed
            res += (blockEnd - blockStart + 1) * ops;

            blockStart *= 4; // Move to the next power-of-4 block
        }

        return res;
    }
}
