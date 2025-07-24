class Solution {
  //solution is small but takes a lot of thinking behind
    public boolean canJump(int[] nums) {
        int maxInd=0;
        for (int i=0; i< nums.length; i++){
            if(i>maxInd) return false;
            if(i+nums[i]>maxInd) maxInd= i+nums[i];            
        }
        return true;        
    }
}
