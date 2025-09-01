class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] indegree= new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //topo sort is what happens first comes first in topological sort
        //So node that should happen first -> the nodes that are dependent on that
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
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

        
        if(topo.size()< numCourses) return new int[]{}; 
        return topo.stream().mapToInt(Integer::intValue).toArray();
    }
}
