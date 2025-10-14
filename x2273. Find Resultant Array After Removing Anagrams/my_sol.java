class Solution {
    public List<String> removeAnagrams(String[] words) {

        String prev= "";
        List<String> ans= new ArrayList<>();
        for (int i=0; i<words.length; i++){
            char[] arr= words[i].toCharArray();
            Arrays.sort(arr);
            String s= new String(arr);
            if (!prev.equals(s))ans.add(words[i]);
            prev=s;            
        }

        return ans;
    }
}
