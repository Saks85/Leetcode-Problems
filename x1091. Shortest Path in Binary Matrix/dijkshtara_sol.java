class Solution {
    class Triple{
        int row,col,dist;
        public Triple(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int n=grid.length;
        int dist[][]= new int[n][n];
        PriorityQueue<Triple> pq= new PriorityQueue<>((a,b)-> a.dist-b.dist);
        pq.offer(new Triple(0,0,1));
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++) dist[i][j]=Integer.MAX_VALUE;
        }
        dist[0][0]=1;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!pq.isEmpty()){
            Triple t= pq.poll();
            int r= t.row;
            int c= t.col;
            int d= t.dist;
            System.out.println("polled:"+r+" "+c+" "+d);
            

            for(int[] i: dir){
                int nr= r+i[0];
                int nc= c+i[1];
                if (nr>=n || nc>=n || nc<0 || nr<0 || grid[nr][nc]==1) continue;
              
                if(dist[r][c]+1< dist[nr][nc]){
                    dist[nr][nc]=dist[r][c]+1;
                    pq.add(new Triple(nr,nc,dist[nr][nc]));
                }
                System.out.println(nr+" "+nc+"  "+dist[nr][nc]); 
            }
        }
        if(dist[n-1][n-1]==Integer.MAX_VALUE) return -1;
        return dist[n-1][n-1];
    }
}
