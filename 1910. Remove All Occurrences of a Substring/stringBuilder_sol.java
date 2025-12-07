class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();
        int n = part.length();

        for (char c : s.toCharArray()) {
            sb.append(c);

            if (sb.length() >= n) {
                boolean match = true;
                for (int i = 0; i < n; i++) {
                    if (sb.charAt(sb.length() - n + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.setLength(sb.length() - n); // delete last n chars
                }
            }
        }

        return sb.toString();
    }
}
