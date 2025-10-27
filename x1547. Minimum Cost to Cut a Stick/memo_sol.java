class Solution {

    private static int f(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = (int) 1e9;
        for (int k =i; k<=j; k++) {
            int cost = arr[j+1] - arr[i-1]
                        + f(i, k-1, arr, dp)
                        + f(k + 1, j, arr, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        int [] arr= new int [cuts.length+2];
        arr[0]=0;
        Arrays.sort(cuts);
        for (int i=0; i<cuts.length; i++){
            arr[i+1]=cuts[i];
        }
        int x= arr.length;
        arr[x-1]= n;
        int[][] dp = new int[x-1][x-1]; //the last ele n will never be passed through the recur
        for (int i = 0; i <x-1; i++) Arrays.fill(dp[i], -1);

        return f(1, x - 2,arr, dp);
    }
}
