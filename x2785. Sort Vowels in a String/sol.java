class Solution {
//   Collecting vowels: O(n)
// Sorting vowels: O(m log m) (where m = number of vowels
// Replacing vowels: O(n)

  //SC: O(m) for storing vowels.
    public String sortVowels(String s) {
        char[] st = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        String vowelSet = "AEIOUaeiou";

        // Step 1: Collect vowels
        for (char c : st) {
            if (vowelSet.indexOf(c) != -1) {
                vowels.add(c);
            }
        }

        // Step 2: Sort the vowels
        Collections.sort(vowels);

        // Step 3: Replace vowels back into string
        int idx = 0;
        for (int i = 0; i < st.length; i++) {
            if (vowelSet.indexOf(st[i]) != -1) {
                st[i] = vowels.get(idx++);
            }
        }

        return new String(st);
    }
}
