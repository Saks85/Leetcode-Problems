class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int ind = 0;  
        int cnt = 1;

        for (int i = 1; i <= n; i++) {

            // end of array OR end of a run
            if (i == n || chars[i] != chars[i - 1]) {

                chars[ind++] = chars[i - 1]; // write character

                if (cnt > 1) {
                    String s = String.valueOf(cnt);
                    for (char c : s.toCharArray()) {
                        chars[ind++] = c;
                    }
                }
                cnt = 1; // reset count
            } 
            else {
                cnt++;
            }
        }
        return ind;
    }
}
