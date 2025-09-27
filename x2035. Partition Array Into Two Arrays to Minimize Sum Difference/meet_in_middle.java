import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 1: Split the array and generate sums for the first half
        List<List<Integer>> leftSums = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            leftSums.add(new ArrayList<>());
        }
        generateSubsetSums(nums, 0, n, 0, 0, leftSums);

        // Step 2: Generate sums for the second half
        List<List<Integer>> rightSums = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            rightSums.add(new ArrayList<>());
        }
        generateSubsetSums(nums, n, 2 * n, 0, 0, rightSums);

        // Step 3: Sort the sums for the right half to enable binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums.get(i));
        }

        int minDiff = Integer.MAX_VALUE;

        // Step 4: Meet in the middle to find the best combination
        // Iterate through all possible subset sizes `k` from the left half
        for (int k = 0; k <= n; k++) {
            // We need `n-k` elements from the right half to make a full partition of size `n`
            List<Integer> rightPartitionSums = rightSums.get(n - k);

            // For each sum `s1` from the left half (using `k` elements)...
            for (int s1 : leftSums.get(k)) {
                // ...find the best corresponding sum `s2` from the right half

                // The target sum for the first partition is totalSum / 2
                // So, the target for the right half's contribution is (totalSum / 2) - s1
                int targetS2 = (totalSum / 2) - s1;

                // Binary search to find the sum in the right half closest to our target
                int low = 0;
                int high = rightPartitionSums.size() - 1;
                int closestS2 = -1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    int s2 = rightPartitionSums.get(mid);

                    if (closestS2 == -1 || Math.abs(s2 - targetS2) < Math.abs(closestS2 - targetS2)) {
                        closestS2 = s2;
                    }

                    if (s2 == targetS2) {
                        break; // Perfect match found
                    } else if (s2 < targetS2) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                if (closestS2 != -1) {
                    int partition1Sum = s1 + closestS2;
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * partition1Sum));
                }
            }
        }

        return minDiff;
    }

    private void generateSubsetSums(int[] nums, int index, int end, int currentSum, int count,
            List<List<Integer>> sums) {
        if (index == end) {
            sums.get(count).add(currentSum);
            return;
        }

        // Case 1: Don't include the current element
        generateSubsetSums(nums, index + 1, end, currentSum, count, sums);

        // Case 2: Include the current element
        generateSubsetSums(nums, index + 1, end, currentSum + nums[index], count + 1, sums);
    }
}
