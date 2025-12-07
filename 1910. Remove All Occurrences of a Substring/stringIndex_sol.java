class Solution {
    public String removeOccurrences(String s, String part) {
        int p=part.length();
        int m=s.length();
       while(true)
       {
         int idx=s.indexOf(part);
         if(idx==-1)
         {
            break;
         }   
         s=s.substring(0,idx)+s.substring(idx+p);
        }
        return s;
      
    }
}
