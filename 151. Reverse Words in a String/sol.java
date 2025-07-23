class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        
        while (left < s.length()) {
            // Skip leading spaces
            while (left < s.length() && s.charAt(left) == ' ') {
                left++;
            }
            
            if (left == s.length()) break;  // If we've reached the end of the string

            // Find the end of the current word
            int right = left;
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }

            // Extract the word and insert it at the beginning of sb
            String word = s.substring(left, right);
            if (sb.length() > 0) {
                sb.insert(0, " ");  // Add space before inserting the next word
            }
            sb.insert(0, word);

            // Move left pointer to the end of the current word
            left = right;
        }

        return sb.toString();
    }
}
