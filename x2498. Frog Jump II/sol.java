class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n==2) return stones[n-1];
        int max= Integer.MIN_VALUE;
        for (int i =0; i<n-2; i++){
            max= Math.max(max, stones[i+2]-stones[i]);
        }
        return max;
    }
}
