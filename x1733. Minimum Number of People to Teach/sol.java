class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int teach=0; boolean found=false;
        HashMap<Integer, HashSet<Integer>> mp= new HashMap<>();
        for(int i=0; i<languages.length; i++){
            mp.put(i+1,new HashSet<>());
            for(int j: languages[i]){
                mp.get(i+1).add(j);
            }
        }

        HashSet<Integer> needTeaching = new HashSet<>();
        for (int[] pair : friendships) {
            int u = pair[0];
            int v = pair[1];

            // Check if they already share a language
            boolean canCommunicate = false;
            for (int lang : mp.get(u)) {
                if (mp.get(v).contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }

            // If not, both are candidates for teaching
            if (!canCommunicate) {
                needTeaching.add(u);
                needTeaching.add(v);
            }
        }
        // If all friendships are fine, no teaching needed
        if (needTeaching.isEmpty()) return 0;

        // Step 3: Try teaching each language and count how many need to learn it
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int countKnows = 0;
            for (int person : needTeaching) {
                if (mp.get(person).contains(lang)) {
                    countKnows++;
                }
            }
            minTeach = Math.min(minTeach, needTeaching.size() - countKnows);
        }

        return minTeach;
    }
}
