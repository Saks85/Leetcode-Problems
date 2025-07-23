class Solution {

    public int beautySum(String s) {
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];  // Frequency of characters

            for (int j = i; j < n; j++) {
                int index = s.charAt(j) - 'a';
                freq[index]++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int k = 0; k < 26; k++) {
                    //iterate through freq arr to get max and min values
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                total += (maxFreq - minFreq);
            }
        }

        return total;        
    }
}
