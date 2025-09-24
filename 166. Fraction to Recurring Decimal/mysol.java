class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        if (!(numerator < 0 && denominator < 0) && (numerator < 0 || denominator < 0)
                && numerator != 0) {
            sb.append('-');
        }

        long num = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        sb.append(num / d);

        num = (num % d);
        if (num == 0)
            return sb.toString();

        sb.append('.');

        Map<Long, Integer> mp = new HashMap<>();
        List<Long> frac = new ArrayList<>();
        int cnt = 0;
        while (num != 0 && !mp.containsKey(num)) {
            mp.put(num, cnt++);
            num = num * 10;
            frac.add((num / d));
            num = num % d;
        }
        int start = (num == 0) ? -1 : mp.get(num);
        for (int i = 0; i < frac.size(); i++) {
            if (i == start) {
                sb.append('(');
            }
            sb.append(frac.get(i));
        }
        if (num != 0)
            sb.append(')');
        return sb.toString();
    }
}
