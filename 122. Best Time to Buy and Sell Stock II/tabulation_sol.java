class Solution {
    private int f(int ind, int buy, int[] prices, int[][]dp){
        if (ind==prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit;
        if (buy==1){
            profit= Math.max(f(ind+1, 0,prices, dp)-prices[ind] , f(ind+1,1,prices,dp));
            //buy so -price OR skip the stock
        }
        else {
            profit=Math.max(f(ind+1,1,prices,dp)+ prices[ind], f(ind+1,0,prices,dp));
            //sell so +price or skip the stock
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][]dp= new int [n+1][2];

        dp[n][0]=0;
        dp[n][1]=0;
        int profit;
        for (int ind=n-1; ind>=0; ind--){
            for (int j=0; j<2; j++){
                if (j==1){
                profit= Math.max(dp[ind+1][0]-prices[ind] , dp[ind+1][1]);
                //buy so -price OR skip the stock
                }
                else {
                    profit=Math.max(dp[ind+1][1]+ prices[ind], dp[ind+1][0]);
                    //sell so +price or skip the stock
                }
                dp[ind][j]=profit;
            }
        }

        return dp[0][1];
    }
}
