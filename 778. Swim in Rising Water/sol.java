class Solution {
    class triplet{
        int row, col, max;
        public triplet(int r, int c, int m){
            this.row=r;
            this.col=c;
            this.max=m;
        }
    }
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        PriorityQueue<triplet> pq= new PriorityQueue<>((a,b)->a.max-b.max);
        int [][] vis =new int [n][n];

        pq.offer(new triplet(0,0, grid[0][0]));
        vis[0][0]=1;
        int maxVal=0;

        int [][]dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            triplet t= pq.poll();
            int r=t.row;
            int c=t.col;
            int m=t.max;
            maxVal=Math.max(m,maxVal);
            //System.out.println(r+" "+c);
            if(r==n-1 && c==n-1) return maxVal;

            for (int [] d: dirs){
                int nr= r+d[0];
                int nc= c+d[1];
                //System.out.println(nr+" new nodes "+nc);
                if (nr>=0 && nc>=0 && nr<n && nc<n && vis[nr][nc]==0){
                    //System.out.println(nr+" adding "+nc);
                    pq.offer(new triplet(nr,nc, grid[nr][nc]));
                    vis[nr][nc]=1;
                }
            }


        }
        return maxVal;
    }
}
