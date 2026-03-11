class Solution {
    public int bitwiseComplement(int n) {
        //xor with 111... will give the complement
        // we just need to know number of bits for a number to know how many 1' to complliment with
        if (n==0) return 1;
        int x=n, i=0;
        while (x!=0){
            x=x>>1;
            i++;
        }
        return n^(int)((1<<i)-1);
    }
}
