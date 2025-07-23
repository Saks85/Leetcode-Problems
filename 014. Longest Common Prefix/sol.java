class Solution {
    public String check (String s1, String s2){
        int n= Math.min(s1.length(),s2.length() );
        int i;
        for (i=0; i<n; i++){
            if (s1.charAt(i)!=s2.charAt(i))
            break;
        }
        return s1.substring(0,i);
    }
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len==0) return "";
        if (len==1) return strs[0];
        String w= check(strs[0], strs[1]);
        for (int i=0; i<len; i++){
            w=check (strs[i],w);
        }
        return w;        
    }
}
