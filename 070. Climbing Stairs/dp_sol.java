class Solution {
    private int count(int n, int[] dp){
        if (n == 1) return 1;
        if(n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int left= count(n-1,dp);
        int right= count(n-2,dp);
        return dp[n]= left+right;
    }
  
    public int climbStairs(int n) {
        //dp appraoch, factorial appraoch
        int []dp= new int[n+1];
        for (int i=0;i<=n; i++){
            dp[i]=-1;
        }
        return count(n,dp);
        
    }
}
