import java.util.*;

class Solution {
    private boolean isPredecessor(String a, String b) {
        if (b.length() != a.length() + 1) return false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }

    private int f(int i, int prev, String[] words, int[][] dp) {
        if (i == words.length) return 0;
        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];

        int len = f(i + 1, prev, words, dp);
        if (prev == -1 || isPredecessor(words[prev], words[i])) {
            len = Math.max(len, 1 + f(i + 1, i, words, dp));
        }

        return dp[i][prev + 1] = len;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(0, -1, words, dp);
    }
}
