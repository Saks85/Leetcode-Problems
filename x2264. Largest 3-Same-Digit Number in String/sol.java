class Solution {
    public String largestGoodInteger(String num) {
        int l=0;
        int r=1;
        int count=0;
        int index=-1;
        while(r<num.length()){
            if (num.charAt(l)==num.charAt(r)){
                count++;
                r++;
            }
            else{
                l=r;
                r++;
                count=0;
            }
            if(count==2){
                if(index==-1 || num.charAt(index)<num.charAt(l)){
                    index=l;
                }
            }
        }
        if (index==-1) return "";
        return (num.substring(index, index+3));       
    }
}
