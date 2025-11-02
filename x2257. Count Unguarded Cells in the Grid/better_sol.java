class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        byte[][] state = new byte[m][n]; // 0=empty,1=guard,2=wall,3=guarded
        for (int[] g : guards) state[g[0]][g[1]] = 1;
        for (int[] w : walls) state[w[0]][w[1]] = 2;

        boolean[] rowGuard = new boolean[m], colGuard = new boolean[n];
        for (int[] g : guards) {
            rowGuard[g[0]] = true;
            colGuard[g[1]] = true;
        }

        // horizontal sweeps
        for (int i = 0; i < m; i++) {
            if (!rowGuard[i]) continue;
            boolean seen = false;
            for (int j = 0; j < n; j++) {
                if (state[i][j] == 2) seen = false;
                else if (state[i][j] == 1) seen = true;
                else if (seen && state[i][j] == 0) state[i][j] = 3;
            }
            seen = false;
            for (int j = n - 1; j >= 0; j--) {
                if (state[i][j] == 2) seen = false;
                else if (state[i][j] == 1) seen = true;
                else if (seen && state[i][j] == 0) state[i][j] = 3;
            }
        }

        // vertical sweeps
        for (int j = 0; j < n; j++) {
            if (!colGuard[j]) continue;
            boolean seen = false;
            for (int i = 0; i < m; i++) {
                if (state[i][j] == 2) seen = false;
                else if (state[i][j] == 1) seen = true;
                else if (seen && state[i][j] == 0) state[i][j] = 3;
            }
            seen = false;
            for (int i = m - 1; i >= 0; i--) {
                if (state[i][j] == 2) seen = false;
                else if (state[i][j] == 1) seen = true;
                else if (seen && state[i][j] == 0) state[i][j] = 3;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (state[i][j] == 0) count++;
        return count;
    }
}
