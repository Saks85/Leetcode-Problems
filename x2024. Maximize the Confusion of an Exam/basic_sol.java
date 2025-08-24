class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int t=0; int f=0;
        int max=0;
        int r=0, l=0;
        char[] ans=answerKey.toCharArray();
        while(l<ans.length && r<ans.length){
            //for T
            if(ans[r]=='T') {
                max=Math.max(max,r-l+1);
                r++;
            }
            else if ( (ans[r]=='F' && f<k)){
                max=Math.max(max,r-l+1);
                f++; r++;
            }
            else if(ans[r]=='F' && f>=k){
                if(ans[l]=='F'){
                    f--;
                }
                l++;
                max=Math.max(max,r-l+1);
                
            }
            
            //System.out.println(l+" "+r+" "+f+" "+max);
        }
        l=0;r=0;
        while(l<ans.length && r<ans.length){
            //for F
            if(ans[r]=='F') {
                max=Math.max(max,r-l+1);
                r++;
            }
            else if ( (ans[r]=='T' && t<k)){
                max=Math.max(max,r-l+1);
                t++; r++;
            }
            else if(ans[r]=='T' && t>=k){
                if(ans[l]=='T'){
                    t--;
                }
                l++;
                max=Math.max(max,r-l+1);
                
            }
            
            //System.out.println(l+" "+r+" "+t+" "+max);
        }
        return max;
    }
}
