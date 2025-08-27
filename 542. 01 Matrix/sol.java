class Solution {
    class Triad{
        int row, col,cnt;
        public Triad(int r, int c,int n){
            this.row=r;
            this.col=c;
            this.cnt=n;

        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Triad> q= new LinkedList<>();
        int[][] res= new int[n][m];
        int[][] vis= new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0) {
                    vis[i][j]=1;
                    q.offer(new Triad(i,j,0));
                }            
            }
        }
        int [][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            Triad node= q.poll();
            int r=node.row;
            int c=node.col;
            int t=node.cnt;
            res[r][c]=t;
            for(int[] d: dir){
                int nr=node.row+d[0];
                int nc=node.col+d[1];
                if(nc>=0 && nc<m && nr>=0 && nr<n && vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.add(new Triad(nr,nc,t+1));
                }
            }
        }
        return res;        
    }
}
