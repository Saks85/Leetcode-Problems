class Solution {
    public boolean doesAliceWin(String s) {
        //the only case bob wins when there are no vowels
        // in all other case if alice play optimally alice would win
        //so it is actually a simple problem if a string contains a vowel or not
        for (int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            //if(c=='a' ||c=='e'||c=='i'||c=='o'||c=='u') return true;
            switch (c) {
                case 'a','e','i','o','u':
                    return true;
            }
        }
        return false;
    }
}
