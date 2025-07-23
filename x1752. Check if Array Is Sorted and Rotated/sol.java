class Solution {
    
    public boolean check(int[] nums) {
        int x=-1;
        int n=nums.length;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){ 
                x=i+1;
                break;
            }
        }
        if(x==-1){
            return true;
        }
        for (int i=x; i<nums.length-1; i++){
            if (nums[i]>nums[i+1]){
                return false;
            }
        }
      //arrays like {2,1,3,4,5} is not sorted and rotated below condition is necessary for such arrays
        if (nums[0]>=nums[nums.length-1]){
            return true;
        }
        return false;
    }
}
