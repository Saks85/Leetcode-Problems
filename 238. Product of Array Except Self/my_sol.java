class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totProd=1;
        int countZeros=0;
        int bef0 =1, aft0=1;
        boolean found=false;
        int [] ans=new int[nums.length];

        for (int i: nums){
            if (found){
                aft0*=i;
            }
            if (i==0){
                countZeros++;
                bef0=totProd;
                found=true;
            }
            totProd*=i;
        }
        for (int i=0;i<nums.length; i++){
            if (nums[i]!=0) ans[i]=(totProd/nums[i]);
            else if (countZeros==1) ans[i]= bef0*aft0;

        }

        return ans;
    }
}
