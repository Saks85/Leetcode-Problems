import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] count = new int[value];

        // Count frequencies of normalized remainders
        for (int num : nums) {
            int rem = ((num % value) + value) % value;
            count[rem]++;
        }

        // The smallest number i whose remainder group is not full yet
        // corresponds to count[i % value]
        int ans = 0;
        while (true) {
            int rem = ans % value;
            if (count[rem] == 0) return ans;
            count[rem]--;
            ans++;
        }
    }
}
