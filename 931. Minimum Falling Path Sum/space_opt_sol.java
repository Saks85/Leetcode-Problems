class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int[] prev= new int[n];

        for (int i=0; i<n;i++){
            int [] curr= new int[n];
            for (int j=0; j<n; j++){
                if (i==0){
                    curr[j]=matrix[i][j];
                }
                else{
                    int down= prev[j];
                    int diagLeft= (j>0)? prev[j-1] : Integer.MAX_VALUE;
                    int diagRight= (j<n-1)? prev[j+1] : Integer.MAX_VALUE;
                    int min= Math.min(down,Math.min(diagLeft, diagRight));
                    //System.out.println(i+ " "+j+ " "+ min);
                    curr[j]= min+matrix[i][j];
                    
                }
                //System.out.println(i+ " "+j+ " "+ dp[i][j]);
            }
            prev=curr;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n ;i++){
            min= Math.min(min, prev[i]);
        }
        return min;
    }
}
