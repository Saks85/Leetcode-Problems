class Solution {
    class Pair{
        int row,col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    private void dfs(int[][] grid,int [][] vis, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] == 0 || vis[i][j]==1) return;
        vis[i][j] = 1;
        dfs(grid,vis, i + 1, j);
        dfs(grid,vis, i - 1, j);
        dfs(grid,vis, i, j + 1);
        dfs(grid,vis, i, j - 1);        
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] vis=new int[m][n];
        int count=0;
        for (int i=0; i<m; i++){
            //leftmost col and rightmost col
            if (vis[i][0]==0 && grid[i][0]==1) dfs(grid, vis, i, 0);
            if (vis[i][n-1]==0 && grid[i][n-1]==1) dfs(grid, vis, i, n-1);
        }
        for(int j=0; j<n; j++){
            //top and bottom row
            if(vis[0][j]==0 && grid[0][j]==1) dfs(grid, vis, 0, j);
            if(vis[m-1][j]==0 && grid[m-1][j]==1) dfs(grid, vis, m-1, j);
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (vis[i][j]==0 && grid[i][j] == 1) count++;
            }
        }
        return count;
        
    }
}
