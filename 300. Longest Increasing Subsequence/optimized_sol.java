class Solution {
    private int lowerBound(int k,int start, int end, List<Integer> list){
        while (end>=start){
            int mid= start+ (end-start)/2;
            if (list.get(mid)<k){
                start=mid+1;
            }
            else {
                end= mid-1;
            }
        }
        return start;
    }

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> temp= new ArrayList<>();
        temp.add(nums[0]);
        int len=1;

        for(int i=1; i<n; i++){
            if (nums[i]>temp.get(len-1)){
                temp.add(nums[i]);
                len++;
            }
            else{
                int ind= lowerBound(nums[i],0,len-1, temp);
                temp.set(ind, nums[i]);
            }
        }
        return len;
    }
}
