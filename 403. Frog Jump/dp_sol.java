class Solution {
    private boolean recur(int[] stones, int index, int jump, Map<String, Boolean> memo) {
        if (stones[index]+jump == stones[stones.length - 1]) return true;  
        if (jump == 0) return false;

        // Memoization key
        String key = index + "," + jump;
        if (memo.containsKey(key)) return memo.get(key);

        int target = stones[index] + jump;

        // Binary search to find the target stone
        int nextIndex = Arrays.binarySearch(stones, index + 1, stones.length, target);
        if (nextIndex < 0) {
            memo.put(key, false);
            return false; // No stone exactly at this position
        }

        // Explore all three next jump options
        boolean canCross = 
            recur(stones, nextIndex, jump - 1, memo) || 
            recur(stones, nextIndex, jump, memo) || 
            recur(stones, nextIndex, jump + 1, memo);

        memo.put(key, canCross);
        return canCross;
    }

    public boolean canCross(int[] stones) {
        // The first jump must always be exactly 1
        if (stones[1] != 1) return false;

        Map<String, Boolean> memo = new HashMap<>();
        return recur(stones, 0, 1, memo);
    }
}
