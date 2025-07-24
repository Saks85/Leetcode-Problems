//this is the solution i did without any help
//Better appraoch would be to go by greedy 
class Solution {
    class Data{
        int ind, turn;
        public Data(int i, int c){
            this.ind=i;
            this.turn=c;
        }
    }
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;

        int maxInd = nums[0], count = 1;
        Queue<Data> q = new ArrayDeque<>();
        Data prev = new Data(0, 0);
        q.add(new Data(maxInd, 1));

        for (int i = 1; i < nums.length; i++) {
            if (maxInd >= nums.length - 1) {
                return count;
            }
            if (i + nums[i] > maxInd) {
                maxInd = i + nums[i];
                if (i > prev.ind && i <= q.peek().ind) {
                    count = q.peek().turn + 1;
                } else {
                    while(q.peek().ind<i) prev = q.poll();  // FIXED: you must update prev
                    count = (q.peek() == null) ? count + 1 : q.peek().turn + 1;
                }
                q.add(new Data(maxInd, count));
            }

            
        }

        return count;  // fallback
    }
}
