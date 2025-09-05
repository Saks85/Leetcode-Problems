class Solution {
    class DisjointSet {
        int[] size;
        int[] parent;

        public DisjointSet(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        public int findPar(int node) {
            if (node == parent[node]) return node;
            return parent[node] = findPar(parent[node]); // Path compression
        }

        public void unionBySize(int u, int v) {
            int par_u = findPar(u);
            int par_v = findPar(v);
            if (par_u == par_v) return;

            if (size[par_u] < size[par_v]) {
                parent[par_u] = par_v;
                size[par_v] += size[par_u];
            } else {
                parent[par_v] = par_u;
                size[par_u] += size[par_v];
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // Not enough cables to connect all

        DisjointSet ds = new DisjointSet(n);

        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            if (ds.findPar(u) != ds.findPar(v)) { // Skip redundant unions
                ds.unionBySize(u, v);
            }
        }

        int discon = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findPar(i) == i) discon++; // Count ultimate parents
        }

        return discon - 1;
    }
}
