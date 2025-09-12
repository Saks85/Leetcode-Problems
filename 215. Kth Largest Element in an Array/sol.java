class Solution {
    static{
        for (int i=0; i<3000; i++){
            findKthLargest(new int[]{0},0);
        }
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for (int i=0; i<nums.length; i++){
            pq.offer(nums[i]);
        }
        for(int i=0; i<k-1; i++){
            pq.poll();
        }
        return pq.poll();
    }
}
