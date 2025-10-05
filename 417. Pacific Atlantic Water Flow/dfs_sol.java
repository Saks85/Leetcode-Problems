import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // DFS from Pacific (top and left borders)
        for (int i = 0; i < m; i++) dfs(heights, pacific, i, 0, heights[i][0]);
        for (int j = 0; j < n; j++) dfs(heights, pacific, 0, j, heights[0][j]);
        
        // DFS from Atlantic (bottom and right borders)
        for (int i = 0; i < m; i++) dfs(heights, atlantic, i, n - 1, heights[i][n - 1]);
        for (int j = 0; j < n; j++) dfs(heights, atlantic, m - 1, j, heights[m - 1][j]);
        
        // Collect cells reachable by both
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] h, boolean[][] visited, int i, int j, int prevHeight) {
        int m = h.length, n = h[0].length;
        
        // Out of bounds or cannot flow "uphill"
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || h[i][j] < prevHeight)
            return;
        
        visited[i][j] = true;
        
        // Explore all 4 directions
        dfs(h, visited, i + 1, j, h[i][j]);
        dfs(h, visited, i - 1, j, h[i][j]);
        dfs(h, visited, i, j + 1, h[i][j]);
        dfs(h, visited, i, j - 1, h[i][j]);
    }
}
