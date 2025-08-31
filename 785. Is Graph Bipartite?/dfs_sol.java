class Solution {

    public boolean dfs(int [][]graph, int start, int []color){
        for (int i=0; i<graph[start].length; i++){
            int num= graph[start][i];
            System.out.println(num+" "+color[num]);
            if (color[num]==0){
                color[num]=(color[start]==1)? 2:1;
                System.out.println(num+" "+color[num]);
                if(!dfs(graph,num,color)) return false;
            }
            else if(color[num]==color[start]) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        if (graph.length==0 || graph.length==1) return true;

        int[] color = new int [graph.length];

        for (int start = 0; start < graph.length; start++) {
            if (color[start] == 0) {
                color[start]=1;
                if(!dfs(graph, start, color)) return false;
            }
        }
    
        return true;

    }
}
