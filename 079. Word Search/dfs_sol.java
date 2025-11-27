class Solution {
    private boolean search(int i,int j,int k, char[][] board,String word, int[][] vis){
        if (k==word.length()-1) return true;

        int[][] dir= {{0,1},{1,0},{-1,0},{0,-1}};

        for (int[] d:dir){
            int ni= i+d[0];
            int nj= j+d[1];

            if (ni>=board.length || nj>= board[0].length || ni<0 ||nj<0 || vis[ni][nj]==1)
                continue;

            if (word.charAt(k+1)== board[ni][nj]){
                vis [ni][nj]=1;
                boolean res= search(ni,nj,k+1, board, word, vis);
                if (res== true) return true;
                vis[ni][nj]=0;
            }
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n= board.length;
        int m= board[0].length;

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (board[i][j]==word.charAt(0)){
                    int[][] vis = new int[n][m];
                    vis[i][j]=1;
                    boolean res= search(i,j,0, board,word, vis);
                    if (res) return true;

                }
            }
        }

        return false;
    }
}
