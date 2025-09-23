class Solution {

    public int uniquePaths(int m, int n) {
        int [] prev =new int[n];
      //replaced dp aray with a prev row array

        for (int i=0; i<m;i++){
            int [] temp= new int [n];
            for (int j=0; j<n; j++){
                
                if (i==0 && j==0) temp[j]=1;
                else{
                    int left=0;
                    int up= prev[j];
                    if(j>0) left= temp[j-1];
                    temp[j]=up+left;
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}
