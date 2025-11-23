class Solution {
    // in this we use mod as the parameter for the dp array
    //taking sum as para can cause space limit exceeded
    //the take and not take variarbles stores the actual sum which is then stored in dp
    int f(int [] nums, int i, int mod, int dp[][]){
        if (i<0) {
            if (mod==0) return 0;
            else return Integer.MIN_VALUE;
        }
        if (dp[i][mod]!=-1) return dp[i][mod];

        int take= nums[i]+ f(nums, i-1, (mod+nums[i])%3,dp);
        int notTake= f(nums, i-1, mod,dp);
        
        return dp[i][mod]= Math.max(take,notTake);
    }
    public int maxSumDivThree(int[] nums) {
        int [][] dp= new int [nums.length][3];
        for (int i=0; i<nums.length; i++) Arrays.fill(dp[i], -1);
        return f(nums, nums.length-1, 0, dp);
    }
}
