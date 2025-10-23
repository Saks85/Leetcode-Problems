class Solution {
    private String summation(String s, int n){
        StringBuilder sb= new StringBuilder();
        for (int i=1; i<n; i++){
            int x= (s.charAt(i)-'0'+s.charAt(i-1)-'0')%10;
            sb.append(x);
        }
        return sb.toString();
        
    }
    public boolean hasSameDigits(String s) {
        int n= s.length();
        String ans=s;
        while (n>2){
            ans= summation(ans,n);
            n= ans.length();
            //System.out.println(ans);
        }
        
        return ans.charAt(0)==ans.charAt(1);
    }
}
