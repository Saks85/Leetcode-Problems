class Solution {
    public int triangularSum(int[] nums) {
        // we have to multiply each with (n-1)C(i) where i is index of the element
        //where n = nums.length
        // and on adding all of them we get our answer
        int n= nums.length-1;
        long res=1;
        long sum= res*nums[0];
        for (int i=1; i<=n; i++){
            res=res*(n-i+1)/i;
            System.out.println(res+" "+ nums[i]);
            // nCr = nC(r-1) * (n-r+1)/n

            sum+=(res* nums[i]);
            sum%=10;
        }

        return (int)sum;
    }
}
