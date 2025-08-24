class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] count = new int[2]; // count[0] = count of 'T', count[1] = count of 'F'
        int left = 0, maxCount = 0, maxLen = 0;
        char[] ans = answerKey.toCharArray();

        for (int right = 0; right < ans.length; right++) {
            // Update count
            if (ans[right] == 'T') count[0]++;
            else count[1]++;

            // Track most frequent character in window
            maxCount = Math.max(maxCount, Math.max(count[0], count[1]));

            // If we need more than k flips, shrink window
            //the maxcount has max of same char and all other are flips
            // so by subtracting we can get the flips
            while ((right - left + 1) - maxCount > k) {
                if (ans[left] == 'T') count[0]--;
                else count[1]--;
                left++;
            }

            // Update max window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
