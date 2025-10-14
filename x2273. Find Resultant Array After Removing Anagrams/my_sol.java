class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        //outer loop : n-2k+1
        for(int i=0; i<=nums.size()-2*k; i++){
            int j=i+1;
            //inner loop: 2k times
            while (j<i+2*k){
                if (nums.get(j-1)<nums.get(j)) j++;
                else if(j-i==k) j++; //j is at index just after getting k elements
                else break;
            }
            if (j==i+2*k) return true;
        }
        return false;
    }
    //TC= ineer* outer = o(n*k)
}
