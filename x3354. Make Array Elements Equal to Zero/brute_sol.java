import java.util.*;

class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try starting in both directions
                if (simulate(nums.clone(), i, 1)) count++;  // right
                if (simulate(nums.clone(), i, -1)) count++; // left
            }
        }

        return count;
    }

    private boolean simulate(int[] nums, int curr, int dir) {
        int n = nums.length;

        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                curr += dir;
            } else {
                nums[curr]--;
                dir = -dir;  // reverse direction
                curr += dir;
            }
        }

        // check if all elements are zero
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}
