class Solution {
  private static final int INF = 1 << 29;
  private int[][] g;

  private int area(int r1, int c1, int r2, int c2) {
    int minR = INF, minC = INF, maxR = -INF, maxC = -INF;
    for (int r = r1; r <= r2; ++r)
      for (int c = c1; c <= c2; ++c)
        if (g[r][c] == 1) {
          if (r < minR) minR = r;
          if (c < minC) minC = c;
          if (r > maxR) maxR = r;
          if (c > maxC) maxC = c;
        }
    return (minR == INF) ? 0 : (maxR - minR + 1) * (maxC - minC + 1);
  }

  public int minimumSum(int[][] grid) {
    g = grid;
    int m = g.length, n = g[0].length;
    int ans = m * n * 3; // upper bound

    // 1) two horizontal cuts
    for (int i1 = 0; i1 < m - 1; ++i1)
      for (int i2 = i1 + 1; i2 < m - 1; ++i2)
        ans = Math.min(ans,
          area(0, 0, i1, n - 1) +
          area(i1 + 1, 0, i2, n - 1) +
          area(i2 + 1, 0, m - 1, n - 1));

    // 2) two vertical cuts
    for (int j1 = 0; j1 < n - 1; ++j1)
      for (int j2 = j1 + 1; j2 < n - 1; ++j2)
        ans = Math.min(ans,
          area(0, 0, m - 1, j1) +
          area(0, j1 + 1, m - 1, j2) +
          area(0, j2 + 1, m - 1, n - 1));

    // 3–6) mixed cuts
    for (int i = 0; i < m - 1; ++i) {
      for (int j = 0; j < n - 1; ++j) {
        // H in top, V in top
        ans = Math.min(ans,
          area(0, 0, i, j) + area(0, j + 1, i, n - 1) + area(i + 1, 0, m - 1, n - 1));
        // H in bottom, V in bottom
        ans = Math.min(ans,
          area(0, 0, i, n - 1) + area(i + 1, 0, m - 1, j) + area(i + 1, j + 1, m - 1, n - 1));
        // V in left, H in left
        ans = Math.min(ans,
          area(0, 0, i, j) + area(i + 1, 0, m - 1, j) + area(0, j + 1, m - 1, n - 1));
        // V in right, H in right
        ans = Math.min(ans,
          area(0, 0, m - 1, j) + area(0, j + 1, i, n - 1) + area(i + 1, j + 1, m - 1, n - 1));
      }
    }
    return ans;
  }
}
