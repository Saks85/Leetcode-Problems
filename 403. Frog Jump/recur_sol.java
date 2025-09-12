class Solution {
  //TC: o(n*3^n)
  //logically correct but gives TLE
    private boolean recur(int stones[],int ind, int jump){
        if (jump==0) return false;
        if (stones[ind] +jump==stones[stones.length-1]) return true;
        int i=ind+1;
        while (i<stones.length && stones[i]<stones[ind]+jump) i++;
        if(i>= stones.length || stones[i]!= stones[ind]+jump) return false;
        boolean back= recur(stones, i, jump-1);
        boolean same= recur(stones, i,jump);
        boolean next= recur(stones, i, jump+1);
        return (back||same||next);

    }
    public boolean canCross(int[] stones) {
        return recur(stones,0,1);
    }
}
