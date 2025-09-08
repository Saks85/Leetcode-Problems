import java.util.*;

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
            int parU = findPar(u);
            int parV = findPar(v);
            if (parU == parV) return;

            if (size[parU] < size[parV]) {
                parent[parU] = parV;
                size[parV] += size[parU];
            } else {
                parent[parV] = parU;
                size[parU] += size[parV];
            }
        }

        public int getSize(int node) {
            return size[findPar(node)];
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n * m);

        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        // Step 1: Union all adjacent land cells
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) continue;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        ds.unionBySize(r * m + c, nr * m + nc);
                    }
                }
            }
        }

       
        int maxCount = 0;
       

        // Step 2: Try flipping each 0 to 1
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 1) continue;

                HashSet<Integer> uniqueIslands = new HashSet<>();
                int currentSize = 1; // flip this zero

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                        int root = ds.findPar(nr * m + nc);
                        if (uniqueIslands.add(root)) { // only add if unique
                            currentSize += ds.getSize(root);
                        }
                    }
                }

                maxCount = Math.max(maxCount, currentSize);
            }
        }
         // Step 3: if all are ones, then this case
        if (maxCount!=0) return maxCount;
        maxCount=ds.getSize(ds.findPar(0));
       
        return maxCount;
    }
}
