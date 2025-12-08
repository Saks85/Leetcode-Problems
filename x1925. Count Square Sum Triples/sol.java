class Solution {
    public int countTriples(int n) {
        int cnt=0;
        for (int i=1; i<=n; i++){
            for (int j=i+1; j<=n;j++){
                long x= (long)Math.sqrt(i*i+j*j);
                if (x<=n && x*x==(i*i+j*j)) {
                    cnt+=2;
                    //System.out.println(x);
                }
            }
        }
        return cnt;
    }
}
