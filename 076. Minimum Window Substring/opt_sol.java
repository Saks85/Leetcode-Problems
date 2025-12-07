class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        if (m > n) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int required = m;  // total characters needed
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < n) {

            char cRight = s.charAt(right);
            // If this char is needed, reduce required count
            if (need[cRight] > 0) required--;

            need[cRight]--; 
            right++;

            // When all needed chars are matched
            while (required == 0) {

                // update minimum window
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // Try shrinking from left
                char cLeft = s.charAt(left);
                need[cLeft]++;

                // If after incrementing, this char becomes needed again,
                // it means we broke the complete window condition.
                if (need[cLeft] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
