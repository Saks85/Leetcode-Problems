class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] indegree= new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // build graph: val->all prerequisites
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for (int i=0; i<numCourses; i++){
            if(indegree[i]==0) q.offer(i);
        }
        List<Integer> topo= new ArrayList<>();
        while(!q.isEmpty()){
            int node= q.poll();
            topo.add(node);
            for (int i =0; i<graph.get(node).size(); i++){
                int x= --indegree[graph.get(node).get(i)];
                if (x==0) q.add(graph.get(node).get(i));
                
            }
        }
        if(numCourses==topo.size()) return true;
        return false;
    }
}
