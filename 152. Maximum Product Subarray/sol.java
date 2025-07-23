class Solution {
    public int maxProduct(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int n=arr.length;
        int prefix=1;
        int suffix=1;
        for (int i=0; i<n; i++){
            prefix = prefix * arr[i];
            suffix= suffix* arr[n-i-1];
            maxSoFar = Math.max(maxSoFar, Math.max(prefix, suffix));

            if (prefix==0) prefix=1;
            if (suffix==0) suffix=1;

        }
        return maxSoFar;
    }
}
