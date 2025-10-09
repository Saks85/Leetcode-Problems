class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n= skill.length;
        int m= mana.length;
        long [] prev= new long [n];
        
        long time;
        for (int j=0; j<n; j++){
            time= skill[j]*mana[0];
            prev[j]=(j==0)? time : prev[j-1]+time;
            //System.out.print(prev[j]+" ");
        }
        //System.out.println();

        for (int i=1; i<m; i++){
            long [] cur = new long [n];

            //getting the time for last wizard
            for (int j=0; j<n; j++){
                time = (long)skill[j]*mana[i];
                cur[j]=(j==0)? prev[j]+time: cur[j-1]+time;
                if (j<n-1 && cur[j]<prev[j+1]) cur[j]= prev[j+1];
            }

            //backpropagating to get ending time of each of the wizard
            for (int j=n-2;j>=0; j--){
                time= (long)skill[j+1]*mana[i];
                cur[j]=cur[j+1]-time;
                //System.out.print(cur[j]+" ");
            }
            //System.out.println();
            prev=cur;
        }

        return prev[n-1];
    }
}
