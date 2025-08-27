class Solution {
    class Pair{
        int row,col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    
    private void dfs(char[][] b, int[][] vis, int r, int c) {
        //dfs is called for edge 0s 
        //all connected to edge 0s should be marked visited 
        // so that no changes are done on them
        int m = b.length, n = b[0].length;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        vis[r][c] = 1;
        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == 0 && b[nr][nc] == 'O') {
                dfs(b, vis, nr, nc);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int [][] vis=new int[m][n];

        // for (int i=0; i<m; i++){
        //     for (int j=0; j<n; j++){
        //         if((i==0 || j==n-1 || j==0 || i==m-1 ) && vis[i][j]==0 && board[i][j]=='O')
        //             dfs(board, vis, i, j);
                
        //     }
        // }
        
        for (int i=0; i<m; i++){
            //leftmost col and rightmost col
            if (vis[i][0]==0 && board[i][0]=='O') dfs(board, vis, i, 0);
            if (vis[i][n-1]==0 && board[i][n-1]=='O') dfs(board, vis, i, n-1);
        }
        for(int j=0; j<n; j++){
            //top and bottom row
            if(vis[0][j]==0 && board[0][j]=='O') dfs(board, vis, 0, j);
            if(vis[m-1][j]==0 && board[m-1][j]=='O') dfs(board, vis, m-1, j);
        }

        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (vis[i][j]==0 && board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}
