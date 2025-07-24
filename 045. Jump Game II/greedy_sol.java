class Solution {
    
    public int jump(int[] nums) {
        int count=0,min=0,max=0;
        while(max<nums.length-1){
            int farthest=0;
            for(int i=min; i<=max; i++){
                farthest=Math.max(farthest,(i+nums[i]));
            }
            min=max+1;
            max=farthest;
            count++;
        }
        
        return count;
    }
}
