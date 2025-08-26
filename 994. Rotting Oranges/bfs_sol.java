class Solution {
    class Triplet{
        int row; int col; int time;
        public Triplet(int r, int c, int t){
            this.row=r;
            this.col=c;
            this.time=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid[0].length;
        int n= grid.length;
        Queue<Triplet> q= new LinkedList<>();
      //finding the rotten ones
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (grid[i][j]==2) q.add(new Triplet(i,j,0));
            }
        }
        int r,c,t=0;
        while (!q.isEmpty()){
            Triplet cur= q.poll();
            r=cur.row;
            c=cur.col;
            t= cur.time;
            if(r-1>=0 && grid[r-1][c]==1){
                grid[r-1][c]=2;
                q.offer(new Triplet(r-1,c,t+1));
            }
            if(r+1<n && grid[r+1][c]==1){
                grid[r+1][c]=2;
                q.offer(new Triplet(r+1,c,t+1));
            }
            if(c-1>=0 && grid[r][c-1]==1){
                grid[r][c-1]=2;
                q.offer(new Triplet(r,c-1,t+1));
            }
            if(c+1<m && grid[r][c+1]==1){
                grid[r][c+1]=2;
                q.offer(new Triplet(r,c+1,t+1));
            }
        }
      //checking if still some fresh orange is left
        for(int i=0; i<n;i++){
            for (int j=0; j<m; j++){
                if (grid[i][j]==1) return -1;
            }
        }
        return t;
    }
}
