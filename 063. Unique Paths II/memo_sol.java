class Solution {
    private int f(int i,int j, int[][] dp, int [][] obstacles){
        if (j<0 || i<0) return 0;
        if (obstacles[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up= f(i-1,j,dp, obstacles);
        int left= f(i,j-1,dp, obstacles);
        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]dp=new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(dp[i],-1);
        return f(m-1,n-1,dp,obstacleGrid);
    }
}
