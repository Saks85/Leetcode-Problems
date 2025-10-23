class Solution { 
  //similar to printing LIS( longest inc subseq)

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int []dp= new int[n];
        int [] hash= new int[n]; //to store the index added to list prev to curr index
        int lastInd= 0;
        int maxi=0;

        for (int i=0; i< n; i++){
            hash[i]=i;
            for (int prev=0; prev<i; prev++){
                if (nums[i]%nums[prev]==0 && dp[i]<dp[prev]+1){
                    dp[i]= dp[prev]+1;
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                lastInd=i;
            }
        }

        List<Integer> ans= new ArrayList<>();
        while(hash[lastInd]!=lastInd){ 
            // the hash 1st character will point to itself as it would have no prev
            ans.add(nums[lastInd]);
            lastInd= hash[lastInd];
        }
        ans.add(nums[lastInd]);

        return ans;
    }
}
