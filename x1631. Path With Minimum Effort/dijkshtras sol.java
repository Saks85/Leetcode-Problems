class Solution {
   
    class Triple{
        int row,col,diff;
        public Triple(int row, int col, int diff){
            this.row=row;
            this.col=col;
            this.diff=diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n= heights[0].length;
        int diff[][]= new int[m][n];
        PriorityQueue<Triple> pq= new PriorityQueue<>((a,b)-> a.diff-b.diff);
        pq.offer(new Triple(0,0,0));
        for (int i=0; i<m; i++){
            for(int j=0; j<n; j++) diff[i][j]=Integer.MAX_VALUE;
        }
        diff[0][0]=0;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            Triple t= pq.poll();
            int r= t.row;
            int c= t.col;
            int d= t.diff;
            if(r==m-1 && c==n-1) return d;
            //System.out.println("polled:"+r+" "+c+" "+d);
            

            for(int[] i: dir){
                int nr= r+i[0];
                int nc= c+i[1];
                if (nr>=m || nc>=n || nc<0 || nr<0 ) continue;
              
                if(Math.max(diff[r][c],Math.abs(heights[r][c]-heights[nr][nc]))< diff[nr][nc]){
                    diff[nr][nc]=Math.max(diff[r][c],Math.abs(heights[r][c]-heights[nr][nc]));
                    pq.add(new Triple(nr,nc,diff[nr][nc]));
                }
                //System.out.println(nr+" "+nc+"  "+diff[nr][nc]); 
            }
        }
        //if(dist[n-1][n-1]==Integer.MAX_VALUE) return -1;
        return diff[n-1][n-1];
    }
}
    
