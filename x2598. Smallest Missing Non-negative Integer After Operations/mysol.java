class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n= nums.length;
        int [] count= new int [value];
        int[] mex= new int[n];

        for (int i=0; i<nums.length; i++){
            int num= nums[i]%value;
            if (num<0) num=num+value;

            int x=count[num]*value+num;
            if (x<n) mex[x]=1;
            count[num]++;
        }

        for (int i=0; i<n; i++){
            if (mex[i]==0) return i;
        }
        return n;
    }
}
