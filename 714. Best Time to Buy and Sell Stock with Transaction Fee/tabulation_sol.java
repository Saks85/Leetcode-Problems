class Solution {

    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int[][]dp= new int [n+1][2];

        dp[n][0]=0;
        dp[n][1]=0;
        int profit;
        for (int ind=n-1; ind>=0; ind--){
            for (int j=0; j<2; j++){
                if (j==1){
                profit= Math.max(dp[ind+1][0]-prices[ind]-fee , dp[ind+1][1]);
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
