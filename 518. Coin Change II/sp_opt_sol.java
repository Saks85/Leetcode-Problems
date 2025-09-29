class Solution {

    public int change(int amount, int[] coins) {
        int n=coins.length;
        int []  prev = new int[amount+1];
        int [] curr= new int[amount+1];
        
        for(int i=0; i<=amount; i++){
            if(i%coins[0]==0) prev[i]= 1;
            else prev[i]=0;
        }

        for (int i=1; i<n; i++){
            for (int j=0; j<=amount; j++){
                int notTake= prev[j];
                int take= 0;
                if (j>= coins[i]){
                    take= curr[j-coins[i]];
                }

                curr[j]= (take+ notTake);
            }
            prev=curr;
        }

        int ans=prev[amount];
        return ans; 
    }
}
