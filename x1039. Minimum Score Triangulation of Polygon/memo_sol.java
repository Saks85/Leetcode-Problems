class Solution {
    //dp matrix chain multiplication 
    //TC: o(n^3)
    private int f(int [] values, int i, int j, int[][]dp){
        if(j-i+1<3) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        int res=Integer.MAX_VALUE;
        for (int k=i+1;k<j; k++){
            int wt= values[i]*values[j]*values[k] +f(values, i,k,dp)+ f(values, k,j,dp);
            res= Math.min(wt,res);

        }
        return dp[i][j]=res;
    }
    public int minScoreTriangulation(int[] values) {
        int n= values.length;
        int [][]dp= new int [n+1][n+1];
        for (int i=0;i<=n;i++) Arrays.fill(dp[i],-1);

        return f(values,0,n-1, dp);
        
    }
}
