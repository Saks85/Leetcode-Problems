class Solution {
    public int minFallingPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int ans = Integer.MAX_VALUE;

        int[][]dp = new int[m][n];
        for(int i=0; i<m ; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int j=0; j<n; j++)
        ans = Math.min(ans, find(arr,n-1, j ,dp));
        return ans;
    }

    int find(int[][]arr, int i, int j, int[][]dp) {
        int n= arr.length;
        if (i<0 || i >= n || j < 0 || j >= n) return Integer.MAX_VALUE;  // ✅ correct

        // return method when readch last
        if( i == 0) return  dp[i][j]=arr[i][j];

        // check if sub problem solved already
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = find(arr, i -1, j, dp);
        int left = find(arr, i -1, j - 1, dp);
        int right = find(arr, i -1, j + 1, dp);

        return  dp[i][j]=arr[i][j] + Math.min(down, Math.min( left, right));
    }
}
