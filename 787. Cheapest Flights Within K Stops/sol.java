class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Step 1: Build adjacency list [u -> (v, cost)]
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Step 2: Distance array to store the cheapest cost to each city
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: BFS queue -> {node, currentCost, stops}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int cost = cur[1];
            int stops = cur[2];

            // We can't make more than k stops
            if (stops > k) continue;

            // Explore neighbors
            for (int[] edge : adj.get(node)) {
                int nextCity = edge[0];
                int price = edge[1];

                // If we find a cheaper path to nextCity
                if (cost + price < dist[nextCity]) {
                    dist[nextCity] = cost + price;
                    q.offer(new int[]{nextCity, cost + price, stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
