//brute force
class Solution {
    public void swap(int i, int j, int [] arr){
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public boolean swap_approach(int[] nums,int index){

        if(index==nums.length){
            int x=0;
            for(int i=0; i<nums.length; i++){
                if(i==0 && nums[i]==0) return false;
                x=(x*10)+nums[i];
            }
            if (x>0 && ((x&x-1)==0)) return true;
        }
        for (int i=index; i<nums.length; i++){
            swap(index,i,nums);
            boolean w= swap_approach(nums, index+1);
            if(w==true) return true;
            swap(index,i,nums);//reswap for backtracking

        }
        return false;
    }
    public boolean reorderedPowerOf2(int n) {
        int[] nums= new int[Integer.toString(n).length()];
        int x=n, i=0;
        while(x>0){
            nums[i++]=x%10;
            x=x/10;
        }
        //this is the swap approach for all permutations
        return swap_approach(nums,0);

    }
}
