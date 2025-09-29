class Solution {
    private int f(int ind, int amount,int [] coins, int[][] dp){

        if (ind==0){
            if(amount%coins[ind]==0) return 1;
            return 0; 
        }

        if(dp[ind][amount]!=-1) return dp[ind][amount];

        int notTake= f(ind-1,amount, coins,dp);
        int take= 0;
        if (amount>= coins[ind]){
            take= f(ind , amount-coins[ind], coins, dp);
        }

        return dp[ind][amount]= (take+ notTake);
    }
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount+1];
        for(int i=0; i< coins.length; i++) Arrays.fill(dp[i],-1);

        int ans= f(coins.length-1, amount, coins, dp);
        //if (ans>=(int)1e9) return -1;
        return ans;
    }
}
