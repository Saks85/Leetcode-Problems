class Solution {
    // static{
    //     for(int i =0; i<300; i++){
    //         minWindow("","");
    //     }

    //}
    public static String minWindow(String s, String t) {
        if (t.length()>s.length()) return "";
        int l=0,r=0,minLen=s.length()+2,cnt=0;
        int left=-1;
        Map <Character, Integer> map=new HashMap<>();
        for (int i=0; i<t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int uniq=map.size();
        while (r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)-1);
            if (map.get(s.charAt(r))==0) cnt+=1;
            while (cnt==uniq) {
                if(minLen>(r-l+1)){
                    left=l;
                    minLen=r-l+1;
                }
                map.put(s.charAt(l),map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0) cnt-=1;
                l++;
            }
            r++;
        }
        if(left==-1 ) return "";
        return s.substring(left,minLen+left);
    }
}
