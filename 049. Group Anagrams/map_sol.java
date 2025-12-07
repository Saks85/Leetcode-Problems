class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert frequency array to a unique key
            StringBuilder key = new StringBuilder();
            for (int cnt : count) {
                key.append('#');   // delimiter to avoid ambiguity
                key.append(cnt);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
