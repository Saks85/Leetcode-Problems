class Solution {
    class Pair {
        int row, col;
        public Pair(int r, int c) {
            row = r; col = c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //can be done using dfs as well
        int n = image.length, m = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc));
        image[sr][sc] = color;

        // 4 directions: up, down, left, right
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int[] d : dirs) {
                int nr = cur.row + d[0], nc = cur.col + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    q.offer(new Pair(nr, nc));
                }
            }
        }
        return image;
    }
}
