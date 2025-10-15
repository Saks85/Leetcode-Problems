class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;
        int max=1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1))
                inc[i] = inc[i - 1] + 1;
            else
                inc[i] = 1;
            //System.out.print(inc[i]+" ");
        }
        //System.out.println();

            for (int i = 0; i<n; i++) {
                // Check if subarray ending at i and one starting at i+1 are both increasing of length k
                
                int x= inc[i];
                while (x>1){
                    if (i+x<n && inc[i+x]>=x){
                        max=Math.max(x,max);
                        break;
                        //System.out.println(i+" "+x);
                    }
                    x--;

                }
            }
        
        return max;
    }
}
