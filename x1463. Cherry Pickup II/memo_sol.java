class Solution {
    private int f(int i, int j1, int j2, int[][] grid, int[][][] dp){
        int n=grid.length;
        int m= grid[0].length;
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) return (int) -1e9;
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        if (i==n-1){
            if(j1==j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int max= (int)-1e8;
        int [] dir= {-1,0,1};
        for(int x: dir){
            for(int y: dir){
                
                max=Math.max(max, f(i+1,j1+x,j2+y,grid, dp));
            }
        }
        int val=(j1==j2)? grid[i][j1]: grid[i][j1]+grid[i][j2];
        return dp[i][j1][j2]= max+val;
    }
    public int cherryPickup(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        int [][][] dp= new int[n][m][m];

        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for (int k=0; k<m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }

        return f(0,0,m-1,grid, dp);
    }
}
