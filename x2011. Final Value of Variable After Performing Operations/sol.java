class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for (String s: operations){
            if(s.charAt(1)=='+') ans+=1;
            else ans-=1;
        }
        return ans;
    }
}
