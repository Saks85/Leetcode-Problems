class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr= text.split(" ");
        int count=0;
        for (String s: arr){
            char[] ch= s.toCharArray();
            for (char c: ch){
                if(brokenLetters.indexOf(c)>=0){
                    count++;
                    break;
                }
            }
        }
        return arr.length-count;
    }
}
