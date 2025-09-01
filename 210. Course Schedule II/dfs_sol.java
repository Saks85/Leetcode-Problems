import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]
        }

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean[] hasCycle = {false}; 

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, pathVis, stack, hasCycle);
                if (hasCycle[0]) return new int[0];
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;
        while (!stack.isEmpty()) {
            order[idx++] = stack.pop();
        }
        return order;
    }

    private void dfs(int node, List<List<Integer>> adj,
                     int[] vis, int[] pathVis, Stack<Integer> stack, boolean[] hasCycle) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int nei : adj.get(node)) {
            if (vis[nei] == 0) {
                dfs(nei, adj, vis, pathVis, stack, hasCycle);
                if (hasCycle[0]) return;
            } else if (pathVis[nei] == 1) {
                hasCycle[0] = true;
                return;
            }
        }

        stack.push(node);
        pathVis[node] = 0;
    }
}
