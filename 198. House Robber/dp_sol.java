class Solution {
    //it is simiar to frog jump of striver only that jump of 1 space can not be done
    public int rob(int[] nums) {
        int n= nums.length;
        int [] dp=new int [n];
        if(n==1) return nums[0];
        if (n==2) return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp[2]=nums[0]+nums[2];
        //since -2 and -3 only 2 steps are possible.... 
        //starting
        for (int i=3; i<n; i++){
            int max=0;
            int fs= dp[i-2]+nums[i];
            int ss= dp[i-3]+nums[i];
            dp[i]= Math.max(fs,ss);
        }
        return Math.max(dp[n-1], dp[n-2]);
    }
}
