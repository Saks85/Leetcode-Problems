class Solution {
    public int numSubmat(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int[]heights=new int[cols];
        int result=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(mat[i][j]==0)heights[j]=0;
                else heights[j]+=1;
            }
            for(int j=0;j<cols;j++){
                int minHeight=Integer.MAX_VALUE;
                for(int k=j;k>=0;k--){
                    if(heights[k]==0)break;
                    minHeight=Math.min(minHeight,heights[k]);
                    result+=minHeight;
                }
            }
        }
        return result;
    }
}
