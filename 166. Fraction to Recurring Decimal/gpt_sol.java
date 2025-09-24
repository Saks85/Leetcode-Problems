class Solution {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
          //change 1-- used xor to check if only 1 is negative
            sb.append('-');
        }

        // Convert to long to avoid overflow (like Integer.MIN_VALUE)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        sb.append(num / den);
        num %= den;

        if (num == 0) return sb.toString(); // No fractional part

        sb.append('.');
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (num != 0) {
            // If this remainder was seen before, it's repeating
            if (remainderMap.containsKey(num)) {
              //change 2 -- used only map and not the array
                int repeatIndex = remainderMap.get(num);
                sb.insert(repeatIndex, '(');
                sb.append(')');
                break;
            }

            // Store current remainder position
            remainderMap.put(num, sb.length());

            num *= 10;
            sb.append(num / den);
            num %= den;
        }

        return sb.toString();
    }
}
