class Solution {
    public String findString(String s) {
        StringBuilder fin = new StringBuilder(s);
        fin.append('1');
        // Reverse and invert
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            fin.append(c == '0' ? '1' : '0');
        }
        return fin.toString();
    }
    public char findKthBit(int n, int k) {
        String s1="0";
        int j=2;
        while (j<=n){
            String fin= findString(s1);
            s1=fin;
            j++;
        }
        
        return s1.charAt(k-1);
    }
}
