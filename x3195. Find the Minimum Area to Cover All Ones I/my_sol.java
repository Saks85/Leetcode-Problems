class Solution {
    public int minimumArea(int[][] grid) {
        int left=-1,right=-1,top=-1,bottom=-1;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    if(left==-1 || j<=left) left=j;
                    if(right==-1 || j>= right) right=j;
                    if(top==-1) top=i;
                    if(bottom==-1|| i>bottom) bottom=i;
                }                
            }
        }
        if(left==-1) return 0;
        return (bottom-top+1)*(right-left+1);       
    }
}
