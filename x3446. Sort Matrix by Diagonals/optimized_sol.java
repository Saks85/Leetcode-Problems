class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // 1. Diagonals starting from first row (top-left to top-right)
        for (int col = 0; col < n; col++) {
            sortDiagonal(grid, 0, col);
        }

        // 2. Diagonals starting from first column (skip [0][0] to avoid duplicate)
        for (int row = 1; row < m; row++) {
            sortDiagonal(grid, row, 0);
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col) {
        int m = grid.length, n = grid[0].length;

        // Step 1: collect diagonal into an array
        int len = Math.min(m - row, n - col);
        int[] diag = new int[len];
        for (int i = 0; i < len; i++) {
            diag[i] = grid[row + i][col + i];
        }

        // Step 2: sort the diagonal
        Arrays.sort(diag);

        // Step 3: decide order
        // If starting point is in top row (row=0, col>0) → increasing
        // Else (starting from left col, row>0) → decreasing
        if (row >= col) {
            reverse(diag); // sort in non-increasing order
        }

        // Step 4: put back into grid
        for (int i = 0; i < len; i++) {
            grid[row + i][col + i] = diag[i];
        }
    }

    // helper to reverse array in-place
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
    }
}
