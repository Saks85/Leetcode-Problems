class Solution {
    private int timer = 1;

    private void dfs(int node, int parent, int[] vis, List<List<Integer>> adj,
                     int[] tim, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tim[node] = low[node] = timer++; // assign and increment timer

        for (int it : adj.get(node)) {
            if (it == parent) continue;

            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tim, low, bridges);
                low[node] = Math.min(low[node], low[it]);

                // Correct bridge condition
                if (low[it] > tim[node]) {
                    bridges.add(Arrays.asList(node, it));
                }
            } else {
                // Back edge
                low[node] = Math.min(low[node], tim[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int[] tim = new int[n];
        int[] low = new int[n];
        List<List<Integer>> bridges = new ArrayList<>();

        // Handle disconnected graph
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, adj, tim, low, bridges);
            }
        }

        return bridges;
    }
}
