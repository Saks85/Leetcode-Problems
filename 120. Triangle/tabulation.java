class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            int s=triangle.get(i).size();
            for (int j = 0; j <s ; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = triangle.get(i).get(j);
                } else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (i > 0 && j<s-1)
                        up = dp[i - 1][j];
                    if (j>0)
                        left = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(up, left) + triangle.get(i).get(j);
                    //System.out.println(i+" "+ j+" "+dp[i][j]);
                }
            }
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.min(max, dp[m-1][i]);
        }
        return max;
    }
}
