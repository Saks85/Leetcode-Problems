class Solution {
    //dp appraoch
    private int f(int ind, int amount,int [] coins, int[][] dp){

        if (ind==0){
            if(amount%coins[ind]==0) return amount/coins[ind];
            return Integer.MAX_VALUE; 
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int notTake= f(ind-1,amount, coins,dp);
        int take= (int)1e9;
        if (amount>= coins[ind]){
            take= 1 + f(ind , amount-coins[ind], coins, dp);
        }

        return dp[ind][amount]= Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0; i< coins.length; i++) Arrays.fill(dp[i],-1);

        int ans= f(coins.length-1, amount, coins, dp);
        if (ans>=(int)1e9) return -1;
        return ans; 
    }
}
