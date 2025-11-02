class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        boolean[][] guarded = new boolean[m][n];

        // Mark guards as 1, walls as 2
        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = 2;

        // Sweep rows left to right and right to left
        for (int i = 0; i < m; i++) {
            boolean seenGuard = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) seenGuard = false;  // wall blocks vision
                else if (grid[i][j] == 1) seenGuard = true;  // guard sees next cells
                else if (seenGuard) guarded[i][j] = true;  // mark as guarded
            }
            seenGuard = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 2) seenGuard = false;
                else if (grid[i][j] == 1) seenGuard = true;
                else if (seenGuard) guarded[i][j] = true;
            }
        }

        // Sweep columns top to bottom and bottom to top
        for (int j = 0; j < n; j++) {
            boolean seenGuard = false;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 2) seenGuard = false;
                else if (grid[i][j] == 1) seenGuard = true;
                else if (seenGuard) guarded[i][j] = true;
            }
            seenGuard = false;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 2) seenGuard = false;
                else if (grid[i][j] == 1) seenGuard = true;
                else if (seenGuard) guarded[i][j] = true;
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !guarded[i][j]) count++;
            }
        }
        return count;
    }
}
