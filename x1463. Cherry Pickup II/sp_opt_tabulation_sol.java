class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // front and curr are both m x m
        int[][] front = new int[m][m];
        int[][] curr = new int[m][m];

        // Base case: fill the last row
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Iterate from second last row up to first
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    // Try all 9 movement combinations
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int newJ1 = j1 + x;
                            int newJ2 = j2 + y;
                            if (newJ1 >= 0 && newJ1 < m && newJ2 >= 0 && newJ2 < m) {
                                max = Math.max(max, front[newJ1][newJ2]);
                            }
                        }
                    }
                    int val = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                    curr[j1][j2] = val + max;
                }
            }
            // Move curr to front for the next iteration
            for (int a = 0; a < m; a++) {
                front[a] = curr[a].clone();
            }
        }

        return front[0][m - 1];
    }
}
