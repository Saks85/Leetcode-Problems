class Solution {
    public int specialTriplets(int[] nums) {
        int cnt=0;
        int mod= (int)(1e9+7);
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int j=0; j<nums.length; j++){
            if (!map.containsKey(nums[j]*2)) {
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                continue;
            }
            int bef= map.get(nums[j]*2);
            for (int k=j+1; k<nums.length; k++){
                if (nums[k]==nums[j]*2){
                    cnt=(cnt+bef%mod)%mod;
                }
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

        }
        return cnt;
    }
}
