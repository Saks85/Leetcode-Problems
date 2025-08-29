class Solution {
    class Pair{
        String st; int n;
        public Pair(String s, int n){
            this.st=s;
            this.n=n;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set= new HashSet<>();
        for (int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair p= q.poll();
            String s=p.st;
            System.out.println(s);
            if(s.equals(endWord)) return p.n;
            
            for (int i=0; i< s.length(); i++){
                char [] charArr= s.toCharArray();
                for(char ch='a'; ch<='z'; ch++){
                    charArr[i]=ch;
                    String changed= new String(charArr);
                    if(set.contains(changed)){
                        q.add(new Pair(changed,p.n+1));
                        set.remove(changed);
                    }
                }
            }
        }
        return 0;
    }
}
