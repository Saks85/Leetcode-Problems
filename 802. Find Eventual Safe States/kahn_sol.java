class Solution {
    List<Integer> eventualSafeNodes(int[][]graph) {
        List<List<Integer>> adjRev = new ArrayList<>();
        int V= graph.length;
        for(int t = 0; t<V; t++) {
            adjRev.add(new ArrayList<>());
        }

        int indegree[] = new int[V];
        for(int t = 0; t<V; t++) {
            // t -> it
            // it -> t
            for(int it : graph[t]) {
                adjRev.get(it).add(t);
                indegree[t]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int t = 0; t<V; t++) {
            if(indegree[t] == 0) q.add(t);
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for(int it : adjRev.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
