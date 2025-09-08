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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n= accounts.size();
        HashMap<String , Integer> map= new HashMap<>();
        DisjointSet ds= new DisjointSet(n);

        //step1 : creating the map
        for (int i=0; i<n ;i++){
            for (int j=1; j<accounts.get(i).size(); j++){
                String st= accounts.get(i).get(j);
                if (map.containsKey(st)){
                    ds.unionBySize(i, map.get(st));
                }
                else {
                    map.put(st,i);
                }
            }
        }

        //Step 2: merging the mails
        ArrayList<String>[] merge= new ArrayList[n];
        for (int i =0; i<n; i++){

            merge[i]=new ArrayList<String>();
        }
        
        for (String st: map.keySet()){
            int node= ds.findPar(map.get(st));
            merge[node].add(st);
        }

        //Step 3: sorting and returning
        List<List<String>> res= new ArrayList<>();
        for (int i=0; i<n ;i++){
            if (merge[i].size()==0) continue;
            Collections.sort(merge[i]);
            List <String> temp= (new ArrayList<>());
            temp.add(accounts.get(i).get(0));
            temp.addAll(merge[i]);
            res.add(temp);
        }

        return res;
    }
}
