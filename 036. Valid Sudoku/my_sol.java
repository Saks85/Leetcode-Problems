class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        List<HashSet<Character>> rows = new ArrayList<>();
        List<HashSet<Character>> cols = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        for (int[] i : row) {
            for (int[] h : row) {
                HashSet<Character> box = new HashSet<>();
                for (int j : i) {
                    for (int k : h) {
                        if (board[j][k] == '.')
                            continue;
                        if (box.contains(board[j][k]) || rows.get(j).contains(board[j][k])
                                || cols.get(k).contains(board[j][k]))
                            return false;
                        box.add(board[j][k]);
                        rows.get(j).add(board[j][k]);
                        cols.get(k).add(board[j][k]);
                    }
                }
            }
        }
        return true;
    }
}
