
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n= grid.length;
        int xor=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n;j++){
                xor^= grid[i][j];
                xor^= (n*i +j+1);
            }
        }
        int bitno=0;
        while ((xor & (1<<bitno))== 0) bitno++; // to get the first differentiating character

        int zero=0; int one=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n;j++){
                if ((grid[i][j]&(1<<bitno))==0) zero^=grid[i][j];
                else one^=grid[i][j];

                if (((n*i+j+1)&(1<<bitno))==0) zero^= (n*i +j+1);
                else one^= (n*i +j+1);
            }
        }
        //System.out.println(zero +" "+ one);
        int [] ans= new int[2];
        for (int i=0; i<n; i++){
            for (int j=0; j<n;j++){
                if (grid[i][j]==zero) {
                    ans[0]= zero;
                    ans[1]=one;
                    return ans;
                }
                if (grid[i][j]==one){
                    ans[0]=one;
                    ans[1]=zero;
                    return ans;
                }

            }
        }
        return ans;
        
    }
}
