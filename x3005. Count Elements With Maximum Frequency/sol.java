class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mp= new HashMap<>();
        int maxCnt=0;
        for (int i: nums){
            int cnt=mp.getOrDefault(i,0);
            mp.put(i,cnt+1);
            maxCnt=Math.max(maxCnt, cnt+1);
        }
        int freq=0;
        for(Integer i: mp.values()){
            if (i==maxCnt) freq+=maxCnt;
        }
        return freq;
    }
}
