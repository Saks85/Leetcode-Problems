class Solution {
  //solution is available on diary 10 december
    public int maxFrequency(int[] nums, int k, int numOperations) {
        //get max element to form freq array
        int maxEl=0;
        for(int i: nums){
            maxEl=Math.max(maxEl, i);
        }
        int [] freq= new int[maxEl+1];

        // get freq
        for (int i: nums){
            freq[i]++;
        }
        //get cumulative freq
        for (int i=1; i<=maxEl; i++){
            freq[i]=freq[i]+freq[i-1];
        }

        //itereate over freq arr and check for each value
        int result=0;
        for (int i=1; i<= maxEl; i++){
            int l= Math.max(0,i-k);
            int r= Math.min(maxEl, i+k);

            int totCount= freq[r]-(l>0? freq[l-1]: 0);
            int noConv= freq[i]-freq[i-1];

            int needConv= totCount-noConv;

            result= Math.max(result, noConv+Math.min(needConv,numOperations));

        }

        return result;
    }
}
