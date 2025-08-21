class Solution {
    public int numSubmat(int[][] mat) {
        //creating heights array
        int [] heights= new int[mat[0].length];
        int ans=0;
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                heights[j]=(mat[i][j]==0)? 0: heights[j]+1;
                //if we get a 1 we should simply increase the value by 1 
            }
            ans+=countRect(heights);
        }
        return ans;        
    }

    private int countRect(int[] heights){
        int m = heights.length;
        int[] sum = new int[m];
        Stack<Integer> stack = new Stack<>();
        int res = 0;

        for (int j = 0; j < m; j++) {
            // Maintain increasing stack
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                int prevIndex = stack.peek();
                sum[j] = sum[prevIndex] + heights[j] * (j - prevIndex);
            } else {
                sum[j] = heights[j] * (j + 1);
            }
            
            stack.push(j);
            res += sum[j];
        }
        return res;
    
    }
}
