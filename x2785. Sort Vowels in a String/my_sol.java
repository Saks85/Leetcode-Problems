class Solution {
  //TC: o(string length + vowel)-- worst case-- o(2n)
  //SC: o(10+number of vowels-- o(n+10)
    public String sortVowels(String s) {
        char [] st= s.toCharArray();
        TreeMap<Character,Integer> map= new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<st.length; i++){
            char c= st[i];
            if (c=='A' || c=='E' || c=='I'||c=='O'||c=='U'||c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                map.put(c,map.getOrDefault(c,0)+1);
                set.add(i);
            }   
        }
        
        for (Map.Entry<Character,Integer> it:map.entrySet()){
            char c= it.getKey();
            int x = it.getValue();
            while (x>0){
                st[set.pollFirst()]=c;
                x--;
            }
        }
        return new String(st);
    }
