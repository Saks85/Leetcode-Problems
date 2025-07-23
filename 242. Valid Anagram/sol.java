class Solution {
    
public boolean isAnagram(String s, String t) {
    //simple maintaining the count of each alphabet
    if (s.length() != t.length()) {
        return false;
    }
    int[] count = new int[26]; 
    
    for (char ch : s.toCharArray()) {
        count[ch - 'a']++;
    }
    for (char ch : t.toCharArray()) {
        count[ch - 'a']--;
        if (count[ch - 'a'] < 0) 
            return false;
        
    }
    
    return true;
        
    }
}
