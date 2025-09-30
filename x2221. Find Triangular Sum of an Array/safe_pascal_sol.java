class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        // Build Pascal's triangle mod 10
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = (C[i-1][j-1] + C[i-1][j]) % 10;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i] * C[n-1][i]) % 10;
        }
        return sum;
    }
}
