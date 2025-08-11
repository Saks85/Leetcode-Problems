class Solution {
    //can be further optimized using a prefix array that keeps track of already calculated values.
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> power= new ArrayList<>();
        int [] res= new int[queries.length];
        int i=0;
        long mod=(long)1e9+7;
        while (n>0){
            if((n&1)==1){
                power.add(1<<i);
            }
            n=n>>1;
            i++;
        }
        //prefix[][] array can be used to calculate and store values.
        //we are going by brute force
        for(i=0; i<queries.length;i++){
            long prod=1;
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                prod=(prod*power.get(j))%mod;
            }
            res[i]=(int)prod;
        }
        return res;        
    }
}
