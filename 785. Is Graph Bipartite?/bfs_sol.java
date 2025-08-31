class Solution {
    class Pair {
        int cur, parent;

        public Pair(int c, int p) {
            this.cur = c;
            this.parent = p;
        }
    }

    public boolean isBipartite(int[][] graph) {
        if (graph.length==0 || graph.length==1) return true;
        Queue<Integer> q = new LinkedList<>();
        int[] colors = new int [graph.length];

        for (int start = 0; start < graph.length; start++) {
            if (colors[start] == 0) {
                q.offer(start);
                colors[start] = 1;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == 0) {
                            colors[neighbor] = (colors[node] == 1) ? 2 : 1;
                            q.offer(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            return false;
                        }
                    }
                }
            }
        }
    
        return true;

    }
}
