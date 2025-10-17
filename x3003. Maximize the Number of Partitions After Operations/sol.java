class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        // Use a memo map: key encodes (i, canChange, mask)
        Map<Long, Integer> memo = new HashMap<>();
        // We return +1 because the recursion returns number of *future* partitions
        return dfs(s, 0, 1, 0, k, memo) + 1;
    }

    // dfs returns: maximum partitions from s[i..end], given current mask, and canChange flag
    private int dfs(String s, int i, int canChange, int mask, int k, Map<Long, Integer> memo) {
        if (i == s.length()) {
            return 0;  // no further characters → no more partitions in recursion
        }

        // Create a unique key for memoization
        // We'll shift i, then include canChange, then include mask
        long key = ((long)i << 27) | ((long)canChange << 26) | mask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: take the current character unchanged
        int bit = 1 << (s.charAt(i) - 'a');
        int newMask = mask | bit;
        int res;
        if (Integer.bitCount(newMask) > k) {
            // must start a new partition here
            res = 1 + dfs(s, i + 1, canChange, bit, k, memo);
        } else {
            // continue in the same partition
            res = dfs(s, i + 1, canChange, newMask, k, memo);
        }

        // Option 2: if we still can change, try changing current char to any other letter
        if (canChange == 1) {
            for (int c = 0; c < 26; c++) {
                int replacedBit = 1 << c;
                int newMask2 = mask | replacedBit;
                if (Integer.bitCount(newMask2) > k) {
                    // starting a new partition because this replacement causes overflow
                    res = Math.max(res, 1 + dfs(s, i + 1, 0, replacedBit, k, memo));
                } else {
                    // continue in same partition
                    res = Math.max(res, dfs(s, i + 1, 0, newMask2, k, memo));
                }
            }
        }

        memo.put(key, res);
        return res;
    }
}
