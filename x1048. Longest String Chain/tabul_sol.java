import java.util.*;

class Solution {
    private boolean isPredecessor(String a, String b) {
        if (b.length() != a.length() + 1) return false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {i++;}
            j++; //j++ happens at every iteration
        }
        return i == a.length();
    }


    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        int maxi=1;
        
        for (int i=0; i<n; i++){
            dp[i]=1;
            for (int prev=0; prev<i; prev++){
                if (isPredecessor(words[prev],words[i]) && dp[prev]+1> dp[i]) 
                dp[i]= dp[prev]+1;
            }
            if (dp[i]>maxi) maxi=dp[i];
        }

        return maxi;
    }
}
