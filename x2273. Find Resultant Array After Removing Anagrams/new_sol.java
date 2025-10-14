class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) inc[i] = inc[i - 1] + 1;
            else inc[i] = 1;
        }

        for (int i = k - 1; i + k < n; i++) {
// Check if subarray ending at i and one starting at i+1 are both increasing of length k
            if (inc[i] >= k && inc[i + k] >= k)
                return true;
        }
        return false;
    }
}
