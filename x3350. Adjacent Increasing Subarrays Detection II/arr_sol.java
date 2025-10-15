class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        if (n <= 1) return 0;

        int[] inc = new int[n];      // length of increasing subarray ending at i
        int[] rightInc = new int[n]; // length of increasing subarray starting at i

        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            inc[i] = (nums.get(i) > nums.get(i - 1)) ? inc[i - 1] + 1 : 1;
        }

        rightInc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightInc[i] = (nums.get(i) < nums.get(i + 1)) ? rightInc[i + 1] + 1 : 1;
        }

        int max = 1;
        for (int i = 0; i < n - 1; i++) {
            int possible = Math.min(inc[i], rightInc[i + 1]);
            max = Math.max(max, possible);
        }

        return max;
    }
}
