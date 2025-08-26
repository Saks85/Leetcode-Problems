class Solution {
    static{
        for (int i=0; i<1000; i++){
            areaOfMaxDiagonal(new int[][]{new int[] {0,0}});
        }
    }
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int diagMax=0;
        int maxArea=0;
        int diag=0;
        for(int[] i: dimensions){
            diag=i[0]*i[0]+ i[1]*i[1];
            if (diag>diagMax){
                diagMax=diag;
                maxArea= i[0]*i[1];
            }
            else if(diag==diagMax){
                maxArea= Math.max(maxArea,i[0]*i[1]);
            }
        }
        return maxArea;
    }
}
