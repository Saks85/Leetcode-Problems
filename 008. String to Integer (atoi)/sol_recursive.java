class Solution {
    public int myAtoi(String s) {
        return helper(s.trim(), 0, 0, 1, false);
    }

    private int helper(String s, int idx, int result, int sign, boolean signSeen) {
        if (idx >= s.length()) return result * sign;

        char ch = s.charAt(idx);

        if (!signSeen && (ch == '+' || ch == '-')) {
            // Only accept the first + or -
            sign = (ch == '-') ? -1 : 1;
            return helper(s, idx + 1, result, sign, true);
        }

        if (!Character.isDigit(ch)) return result * sign;

        int digit = ch - '0';

        // Check for overflow/underflow
        if (sign == 1 && (result > (Integer.MAX_VALUE - digit) / 10)) return Integer.MAX_VALUE;
        if (sign == -1 && (-result < (Integer.MIN_VALUE + digit) / 10)) return Integer.MIN_VALUE;

        result = result * 10 + digit;
        return helper(s, idx + 1, result, sign, true);  // signSeen = true after first digit or sign
    }
}
