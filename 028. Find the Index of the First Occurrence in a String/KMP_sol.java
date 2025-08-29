class Solution {
    public int strStr(String haystack, String needle) {
        //KMP implementation
        if (needle.isEmpty()) return 0;
        
        int n = haystack.length();
        int m = needle.length();
        
        // Step 1: Build LPS array for needle
        int[] lps = buildLPS(needle);
        
        // Step 2: Search using LPS
        int i = 0, j = 0; // i -> haystack, j -> needle
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++; j++;
                if (j == m) {
                    return i - j; // Found match
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // fallback using LPS
                } else {
                    i++; // move haystack forward
                }
            }
        }
        return -1; // not found
    }
    
    // Helper: Build LPS array
    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;
        
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
