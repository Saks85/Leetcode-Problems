import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {

        Arrays.sort(nums); // Sort the array

        // Start from the largest side
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0; // No valid triangle
    }
}
