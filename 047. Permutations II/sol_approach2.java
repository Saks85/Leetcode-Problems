class Solution {
    public void swap(int i, int j, int [] arr){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public List<List<Integer>> swap_approach(int[] nums,int index, List<List<Integer>> ans){
        //mark the element which have been used
        //recursive mark all the elements in different orders to get the permutations
        if(index==nums.length){
            List<Integer> ds= new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return ans;
        }
        Set<Integer> used = new HashSet<>(); // track values used at this recursion level
        for (int i=index; i<nums.length; i++){
            if (used.contains(nums[i])) continue; // skip duplicate value at this level
            used.add(nums[i]);
            swap(index,i,nums);
            swap_approach(nums, index+1, ans);
            swap(index,i,nums);//reswap for backtracking

        }
        return ans;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();

        result= swap_approach(nums,0,result);
        return result;
                
    }
}
