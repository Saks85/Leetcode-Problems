class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        // Fix the largest side at index k
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    // All values from i to j-1 with nums[j] will form valid triangles
                    count += (j - i);
                    j--; // move j left
                } else {
                    i++; // increase sum
                }
            }
        }
        return count;
    }
}
