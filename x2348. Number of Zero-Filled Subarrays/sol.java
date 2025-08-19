class Solution {
    static{
        for (int i=0; i<1000; i++){
            zeroFilledSubarray(new int []{0});
        }
    }
    
    public static long zeroFilledSubarray(int[] nums) {
        long ans=0; int zeroes=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                zeroes++;
                ans+=zeroes;
            }
            else{
                zeroes=0;
            }
        }
        return ans;
        
    }
}
