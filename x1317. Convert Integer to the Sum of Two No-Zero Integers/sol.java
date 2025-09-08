class Solution {
    public int[] getNoZeroIntegers(int n) {
        int ans[] = new int[2];
        int a,b;
        for(int i=1; i<=n/2 ; i++){
            ans[0]=i;
            ans[1]=n-i;
            a=i; b=n-i;
            //System.out.println(a+" "+b);
            while(a>9 && a%10!=0){
                a=a/10;
            }
            if(a>9) continue;
            while(b>9 && b%10!=0){
                b=b/10;
            }
            if(b<10) return ans;            
        }
        return ans;
    }
}
