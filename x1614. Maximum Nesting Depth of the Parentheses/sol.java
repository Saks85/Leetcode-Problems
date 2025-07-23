class Solution {
    public int maxDepth(String s) {
        int curr=0; int max=0;
        for (char c : s.toCharArray()){
            if (c=='('){
                curr--;
            }
            else if (c==')'){
                curr++;
            }
            if (curr<max) max=curr;
        }
        return max*-1;
        
    }
}
