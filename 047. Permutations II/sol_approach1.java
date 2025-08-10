class Solution {
    public List<List<Integer>> flag_approach(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] flag){
        //mark the element which have been used
        //recursive mark all the elements in different orders to get the permutations
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            //here adding ds as a new arrayList is very Important as ds is mutable
            //so that ans doesnot change with changing values of ds
            return ans;
        }
        for (int i=0; i<nums.length; i++){
            if(!flag[i]){
                // skip duplicates — only allow the first unused duplicate in a sequence
                if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) continue;
                flag[i]=true;
                ds.add(nums[i]);
                flag_approach(nums, ds, ans,flag);
                //next 2 steps to allow backtracking
                ds.remove(ds.size()-1);
                flag[i]=false;
            }
        }
        return ans;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flag= new boolean[nums.length];
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);//sorting array to remove duplicates at the time of generation

        result= flag_approach(nums, new ArrayList<Integer>(),result ,flag);
        return result;
                
    }
}
