class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Initialize constraints
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '1';                 // 0..8
                int box = (i / 3) * 3 + (j / 3);   // 0..8
                rows[i][num] = cols[j][num] = boxes[box][num] = true;
            }
        }

        dfs(board, rows, cols, boxes);
    }

    private boolean dfs(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] boxes) {
        int bestI = -1, bestJ = -1;
        int minCount = 10;

        // store candidates for the best cell
        int[] bestCand = new int[9];
        int bestLen = 0;

        // Step 1: choose next cell using MRV (minimum remaining values)
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;

                int box = (i / 3) * 3 + (j / 3);
                int cnt = 0;
                int[] curCand = new int[9];

                for (int k = 0; k < 9; k++) {
                    if (!rows[i][k] && !cols[j][k] && !boxes[box][k]) {
                        curCand[cnt++] = k + 1; // store possible numbers
                    }
                }

                if (cnt == 0) return false; // dead end

                if (cnt < minCount) {
                    minCount = cnt;
                    bestI = i;
                    bestJ = j;
                    bestLen = cnt;
                    System.arraycopy(curCand, 0, bestCand, 0, cnt);
                    if (cnt == 1) break; // cannot do better
                }
            }
            if (minCount == 1) break;
        }

        // Step 2: if no empty cells found => solved
        if (bestI == -1) return true;

        // Step 3: try candidates
        int b = (bestI / 3) * 3 + (bestJ / 3);
        for (int idx = 0; idx < bestLen; idx++) {
            int val = bestCand[idx];
            int k = val - 1;

            // place value
            board[bestI][bestJ] = (char) ('0' + val);
            rows[bestI][k] = cols[bestJ][k] = boxes[b][k] = true;

            // recurse
            if (dfs(board, rows, cols, boxes)) return true;

            // undo (backtrack)
            board[bestI][bestJ] = '.';
            rows[bestI][k] = cols[bestJ][k] = boxes[b][k] = false;
        }

        return false; // none worked
    }
}
