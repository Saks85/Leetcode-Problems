class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for(int i=0; i<=nums.size()-2*k; i++){
            int j=i+1;
            while (j<i+2*k){
                if (nums.get(j-1)<nums.get(j)) j++;
                else if(j-i==k) j++; //j is at index just after getting k elements
                else break;
            }
            if (j==i+2*k) return true;
        }
        return false;
    }
}
