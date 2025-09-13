class Solution {
    public int maxFreqSum(String s) {
        char[] st= s.toCharArray();
        int [] freq= new int [26]; 
        for (int i=0; i<st.length; i++){
            freq[st[i]-'a']++;
        }
        int vow=0; int cons=0;
        // for (int i: freq){
        //     System.out.print(i+" ");
        // }
        for (int i =0; i<26; i++){
            switch(i){
                case 0,4,8,14,20:
                vow=Math.max(vow,freq[i]);
                break;

                default:
                cons=Math.max(cons, freq[i]);
            }
            //System.out.println(i+" "+vow+" "+cons);
        }

        return vow+cons;
    }
}
