class Solution {
    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    private void add(List<Integer> li, int x) {
        while (!li.isEmpty()) {
            int last = li.get(li.size() - 1);
            int g = gcd(last, x);
            if (g == 1)
                break;
            li.remove(li.size() - 1);
            x = (int) ((long) x * (last / g)); // prevent overflow using long
        }
        li.add(x);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for (int num : nums) {
            add(li, num);
        }
        return li;
    }
}
