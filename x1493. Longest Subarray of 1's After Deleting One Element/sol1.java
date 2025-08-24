class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            // If more than 1 zero, shrink from left
            while (zeros > 1) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            // Length is window size - 1 (because we must delete one element)
            max = Math.max(max, right - left);
        }

        return max;
    }
}
