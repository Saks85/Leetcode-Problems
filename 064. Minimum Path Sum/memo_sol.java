class Solution {
    private int f(int i,int j, int[][] dp, int [][] grid){
        if (j<0 || i<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up= f(i-1,j,dp,grid);
        int left= f(i,j-1,dp,grid);

        return dp[i][j]=Math.min(up,left)+grid[i][j];
    }
    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n=grid[0].length;
        int [][]dp=new int[m][n];
        for (int i=0; i<m; i++) Arrays.fill(dp[i],-1);
        return f(m-1,n-1,dp,grid);
    }
}
