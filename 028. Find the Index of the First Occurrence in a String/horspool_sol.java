import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        int m = needle.length();
        int n = haystack.length();

        // Step 1: Build shift hashmap
        Map<Character, Integer> shiftMap = new HashMap<>();
        for (int i = 0; i < m - 1; i++) {
            shiftMap.put(needle.charAt(i), m - 1 - i);
        }

        // Step 2: Search
        int i = 0;
        while (i <= n - m) {
            int j = m - 1; // start comparing from end of needle
            while (j >= 0 && needle.charAt(j) == haystack.charAt(i + j)) {
                j--;
            }
            if (j < 0) {
                return i; // match found
            } else {
                char badChar = haystack.charAt(i + m - 1);
                int shift = shiftMap.getOrDefault(badChar, m);
                i += shift;
            }
        }
        return -1; // no match
    }
}
