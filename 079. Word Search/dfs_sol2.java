class Solution {

    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        if (board[i][j] != word.charAt(k))
            return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean found =
                dfs(board, i+1, j, word, k+1) ||
                dfs(board, i-1, j, word, k+1) ||
                dfs(board, i, j+1, word, k+1) ||
                dfs(board, i, j-1, word, k+1);

        board[i][j] = temp; // restore

        return found;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0))
                        return true;
                }
            }
        }

        return false;
    }
}
