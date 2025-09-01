class Solution {
    public boolean dfs(int[][] graph, int[] vis, int[] pathVis, int node, int check[]) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node]=0;
        for (int i : graph[node]) {
            if (vis[i] == 0) {
                if (dfs(graph, vis, pathVis, i, check)) {
                    return true;
                }
            } else if (pathVis[i] == 1 && vis[i] == 1) {
                return true; //cycle detected
            }
        }
        check[node]=1;
        pathVis[node]=0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int check[] = new int[graph.length];
        int[] pathVis = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0)
                dfs(graph, vis, pathVis, i, check);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }
}
