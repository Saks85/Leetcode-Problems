class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int[][] dp= new int[n][n];

        for (int i=0; i< n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                if (i==0){
                    dp[i][j]=matrix[i][j];
                }
                else{
                    int down= dp[i-1][j];
                    int diagLeft= (j>0)? dp[i-1][j-1] : Integer.MAX_VALUE;
                    int diagRight= (j<n-1)? dp[i-1][j+1] : Integer.MAX_VALUE;
                    int min= Math.min(down,Math.min(diagLeft, diagRight));
                    //System.out.println(i+ " "+j+ " "+ min);
                    dp[i][j]= min+matrix[i][j];
                    
                }
                //System.out.println(i+ " "+j+ " "+ dp[i][j]);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n ;i++){
            min= Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}
