class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;
        boolean up = true;

        for (int i = 0; i < m * n; i++) {
            res[i] = mat[r][c];

            if (up) { // going up-right ↗
                if (c == n - 1) { // hit right boundary
                    r++;
                    up = false;
                } else if (r == 0) { // hit top boundary
                    c++;
                    up = false;
                } else { // normal move
                    r--;
                    c++;
                }
            } else { // going down-left ↙
                if (r == m - 1) { // hit bottom boundary
                    c++;
                    up = true;
                } else if (c == 0) { // hit left boundary
                    r++;
                    up = true;
                } else { // normal move
                    r++;
                    c--;
                }
            }
        }

        return res;
    }
}
