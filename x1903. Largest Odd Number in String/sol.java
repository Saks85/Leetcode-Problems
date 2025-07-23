class Solution {
    public String largestOddNumber(String num) {
        int min= 0;
        //to get the odd number and last number should be odd
        //so we iterate from back and as we get an odd number we get the largest odd integer
        for (int i = num.length()-1; i>=0; i--){
            int n= num.charAt(i)-'0';
            if (n%2!=0){
                return num.substring(0,i+1);
            }
            

        }
        return "";
        
    }
}
