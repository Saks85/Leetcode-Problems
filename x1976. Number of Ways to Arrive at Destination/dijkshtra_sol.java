class Solution {
    class Pair {
        int val;
        long dist;

        public Pair(int node, long dist) {
            this.val = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        long[] dist = new long[n];
        int[] ways = new int[n];
        int mod = (int) 1e9 + 7;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        // Initialize graph and distances
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE; // FIXED
        }

        for (int[] r : roads) {
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int val = p.val;
            long dis = p.dist;

            // Skip outdated entries
            if (dis > dist[val]) continue; // FIXED

            for (Pair edge : adj.get(val)) {
                int v = edge.val;
                long wt = edge.dist;

                if (dist[v] > dis + wt) {
                    dist[v] = dis + wt;
                    ways[v] = ways[val] % mod; // FIXED
                    pq.offer(new Pair(v, dist[v]));
                } else if (dist[v] == dis + wt) {
                    ways[v] = (ways[v] + ways[val]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
