import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        String ans = s;
        int n = s.length();

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(s);

        Set<String> visited = new HashSet<>();
        visited.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            // update answer
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }

            // Operation 1: add a to odd indices
            char[] arr1 = cur.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int digit = arr1[i] - '0';
                digit = (digit + a) % 10;
                arr1[i] = (char) (digit + '0');
            }
            String t1 = new String(arr1);
            if (!visited.contains(t1)) {
                visited.add(t1);
                queue.offer(t1);
            }

            // Operation 2: rotate right by b positions
            // If b may be > n, reduce b mod n
            int bb = b % n;
            String t2 = cur.substring(n - bb) + cur.substring(0, n - bb);
            if (!visited.contains(t2)) {
                visited.add(t2);
                queue.offer(t2);
            }
        }

        return ans;
    }
}
