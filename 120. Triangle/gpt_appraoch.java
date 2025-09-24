class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] front = new int[n]; // Stores the results for the current row
        int[] cur = new int[n];   // Stores the results for the next row

       
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n-1).get(j);
        }

        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle.get(i).get(j) + front[j];
                int diagonal =  triangle.get(i).get(j) + front[j + 1];

                // Store the minimum of the two paths in the cur array
                cur[j] = Math.min(down, diagonal);
            }
            
            // Update the front array with the values from the cur array for the next row
            front = cur.clone();
        }

        // The result is stored at the top of the front array
        return front[0];
    }
}
