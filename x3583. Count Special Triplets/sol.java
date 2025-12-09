class Solution {
    public int specialTriplets(int[] nums) {
        int mod = (int)1e9 + 7;
        long cnt = 0;

        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        // Build frequency map for right side
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0) + 1);
        }

        for (int j = 0; j < nums.length; j++) {

            int val = nums[j];
            right.put(val, right.get(val) - 1);  // move j from right to middle

            int target = val * 2;

            long before = left.getOrDefault(target, 0);   // i < j
            long after  = right.getOrDefault(target, 0);  // k > j

            cnt = (cnt + (before * after) % mod) % mod;

            left.put(val, left.getOrDefault(val, 0) + 1); // move j to left
        }

        return (int)cnt;
    }
}
