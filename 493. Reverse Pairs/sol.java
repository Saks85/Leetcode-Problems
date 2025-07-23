class Solution {
    public int mergeSort(int[] arr, int low, int high){
        int count=0;
        if(high<=low) return count;
        int mid=low+(high-low)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1, high);
        count+=countPairs(arr,low,mid,high);
        merge(arr, low,mid,high);
        return count;
    }
    public void merge(int [] arr, int low, int mid, int high){
        int [] temp= new int[high-low+1];
        int i=0;
        int left=low;
        int right=mid+1;
        while (right<=high && left<=mid){
            if (arr[left]<=arr[right]) {
                temp[i++]=arr[left++];
            }
            else temp[i++]=arr[right++];
        }
        while(left<=mid){
            temp[i++]=arr[left++];
        }
        while (right<=high) temp[i++]=arr[right++];
        i=0;
        for(int j=low; j<=high;j++){
            arr[j]=temp[i++];
        }
    }
    public int countPairs(int [] arr, int low, int mid, int high){
        int count=0;
        int right=mid+1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * (long)arr[right]) right++;
            count += (right - (mid + 1));
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}
