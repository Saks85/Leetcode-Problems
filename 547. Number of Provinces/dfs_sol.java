class Solution {
    private void dfs(int node, boolean[] vis, List<List<Integer>> adj){
            vis[node]=true;
            for(Integer it: adj.get(node)){
                if(vis[it]==false){
                    dfs(it, vis, adj);
                }
            }
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] vis=new boolean[n];
        List<List<Integer>> adj= new ArrayList<>();
        //converting adjacency matrix to adjacency list
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1) adj.get(i).add(j);                
            }
        }
        int count=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                //vis[i]=true;
                count++;
                dfs(i,vis,adj);
            }

        }
        return count;       
    }
}
