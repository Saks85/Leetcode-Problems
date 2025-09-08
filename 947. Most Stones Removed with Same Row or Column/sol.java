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
    public int removeStones(int[][] stones) {
        //we need to know the maxRow and maxCol
        int maxRow=0, maxCol=0;
        for (int []i : stones){
            maxRow= Math.max(maxRow, i[0]);
            maxCol= Math.max(maxCol, i[1]);
        }
        DisjointSet ds = new DisjointSet(maxRow+maxCol+2);
        HashSet<Integer> set= new HashSet<>();
        for (int[] conn :stones) {
            int u = conn[0];
            int v = conn[1]+maxRow+1;
            //System.out.println(u+" "+v);

            ds.unionBySize(u, v);
            set.add(u);
            set.add(v);
            
        }

        int discon = 0;
        
        for (int i :set) {

            if (ds.findPar(i)==i) discon++; // Count ultimate parents

        }

        return stones.length- discon;
    }
}
