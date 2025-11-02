class Solution {
    private void deep(int i, int j, int m, int n, int [][] vis){
        int[][] dir={{-1,0,4},{0,1,5},{0,-1,6},{1,0,7}};
        //3rd parementer helps to not recheck the blocks in same direction by a diff guard
        //left=4 .. so while going left if i get 4 in vis arr
        // i can say that all others possible would have been visited already 
        vis[i][j]=1;
        for (int [] d: dir){
            int iNew=i+d[0];
            int jNew= j+d[1];
            while (iNew>=0 && jNew>=0 && iNew<m && jNew<n && vis[iNew][jNew]!=-1 && vis[iNew][jNew]!=d[2]){
                vis[iNew][jNew]=d[2];
                iNew+=d[0];
                jNew+=d[1];
            }
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int [][] vis= new int [m][n];
        for (int [] w: walls){
            vis[w[0]][w[1]]=-1;
        }

        for (int []g: guards){
            deep(g[0],g[1],m,n,vis);
        }
        int count=0;
        for(int i=0; i<m;i++){
            for (int j=0; j<n; j++){
                if (vis[i][j]==0) count++;
            }
        }
        return count;
    }
}
