class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count=new int [26];
        int m=s1.length();
        int n=s2.length();
        if (n<m) return false;
        for (int i=0; i<m; i++){
            count[s1.charAt(i)-'a']++;
        }
        int uniq=0;
        for (int i=0; i<26; i++){
            if (count[i]>0) uniq++;
        }

        int match =0;
        for (int i=0; i<m; i++){
            int ind=s2.charAt(i)-'a';
            count[ind]--;
            if(count[ind]==0) match++;
        }
        if(uniq==match) return true;

        for (int i=m; i<n; i++){
            int ind= s2.charAt(i-m)-'a';
            if (count[ind]==0){    
                match--;
            }
            count[ind]++;

            ind= s2.charAt(i)-'a';
            count[ind]--;
            if(count[ind]==0) match++;
            System.out.println(count[ind]+" "+ind+" "+match);
            if(uniq==match) return true;
        }
        return false;
        
    }
}
