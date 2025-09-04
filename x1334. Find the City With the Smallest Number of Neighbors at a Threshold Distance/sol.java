class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];

        // Proper initialization
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    cost[i][j] = 0;
                else
                    cost[i][j] = Integer.MAX_VALUE;
            }
        }

        // Fill graph with given edges
        for (int[] edge : edges) {
            cost[edge[0]][edge[1]] = edge[2];
            cost[edge[1]][edge[0]] = edge[2];
        }

        // Floyd-Warshall
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][via] != Integer.MAX_VALUE && cost[via][j] != Integer.MAX_VALUE) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][via] + cost[via][j]);
                    }
                }
            }
        }

        // Find city with smallest number of reachable cities
        int min = n + 1;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && cost[i][j] <= distanceThreshold) { // FIXED
                    count++;
                }
            }
            if (min >= count) { // if tie, choose larger index
                min = count;
                ans = i;
            }
        }

        return ans;
    }
}
