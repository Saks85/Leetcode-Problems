class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        for (int i=0; i<wordList.size(); i++){
            dict.add(wordList.get(i));
        }
        if (!dict.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Always expand the smaller frontier
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);

                        if (endSet.contains(newWord)) return len + 1;

                        if (dict.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            nextLevel.add(newWord);
                        }
                    }
                    arr[i] = original;
                }
            }
            beginSet = nextLevel;
            len++;
        }
        return 0;
    }
}
