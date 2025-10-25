class Solution {
    private boolean isBalanced(int n){
        int [] freq= new int [10];
        while(n>0){
            freq[n%10]++;
            n=n/10;
        }
        for (int i=0; i<10; i++){
            if (freq[i]!=0 && freq[i]!=i) return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        for (int i=n+1; i<Integer.MAX_VALUE; i++){
            if (isBalanced(i)) return i;
        }
        return 0;//dummy return
    }
}
