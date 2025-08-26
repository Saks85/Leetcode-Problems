class Solution {
    private void dfs(int node, boolean[] vis, int[][] adj){
            vis[node]=true;
            int n=adj.length;
            for(int i=0; i<n; i++){
                if(vis[i]==false && adj[node][i]==1){
                    dfs(i, vis, adj);
                }
            }
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        boolean[] vis=new boolean[n];
        
        int count=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                //vis[i]=true;
                count++;
                dfs(i,vis,isConnected);
            }

        }
        return count;       
    }
}
