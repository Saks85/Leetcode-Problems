class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0, prev=0, curr=0;
        for (int i=0; i<bank.length; i++){
            char[] arr= bank[i].toCharArray();
            for (char c: arr){
                if (c=='1') curr++;
            }
            if (curr!=0){
                ans+= prev*curr;
                prev=curr;
                curr=0;
            }
        }
        return ans;
    }
}
