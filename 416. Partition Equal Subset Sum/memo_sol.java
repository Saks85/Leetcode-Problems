class Solution {
    private int f(int ind, int k, int[] arr, int [][] dp){
        if(k==0) return 1;
        if(ind==0) {
            if (arr[ind]==k) return dp[ind][k]=1;
            else return dp[ind][k]=0;
        }
        if (dp[ind][k]!=-1) return dp[ind][k];
        int notTake= f(ind-1, k, arr, dp);
        int take =0;
        if (k>= arr[ind]){
            take= f(ind-1, k-arr[ind],arr,dp);
        }
        
        if (take==1 || notTake==1) return dp[ind][k]=1;
        return dp[ind][k]=0;
    }
    public boolean canPartition(int[] nums) {
        int n= nums.length; int sum=0;
        for (int i=0; i<n; i++){
            sum+=nums[i];
        }
        if (sum%2!=0) return false;
        sum=sum/2;

        int [][] dp= new int [n][sum+1];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return (f(n-1,sum,nums,dp)==1);
    }
}
