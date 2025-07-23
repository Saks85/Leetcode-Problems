class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length()!= t.length()) return false;
        char [] c1= s.toCharArray();
        char[] c2= t.toCharArray();
        Map <Character,Character> mp= new HashMap<>();
        for (int i=0; i<c1.length; i++){
            if (mp.containsKey(c1[i]) ){
                if (mp.get(c1[i])!=c2[i])
                return false;
            }
            else if (mp.containsValue(c2[i]) ) return false;
            else {
                mp.put (c1[i],c2[i]);
            }
        }
        return true;
        
    }
}
