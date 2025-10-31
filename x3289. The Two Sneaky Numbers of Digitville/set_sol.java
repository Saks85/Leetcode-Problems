class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int [] ans= new int [2];
        Set<Integer> set= new HashSet<>();
        int x=0;
        for (int i: nums){
            if(set.contains(i)) ans[x++]=i;
            else set.add(i);
        }

        return ans;
    }
}
