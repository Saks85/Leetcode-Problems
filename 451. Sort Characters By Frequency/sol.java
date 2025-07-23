//using Priority Queue and more inbuilt-functions
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq= new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        pq.addAll(mp.entrySet());
        StringBuilder res=new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            res.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));

        }
        return res.toString();
        
    }
}

//a more logical appraoch given below
class Solution {

    static {
        for (int i = 0; i < 500; i++) {
            frequencySort(new String());
        }
    }
    public static int findMaxI(int[] f) {
        int maxi = 0;
        int max = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] > max) {
                maxi = i;
                max = f[i];
            }
        }
        return maxi;
    }

    public static String frequencySort(String s) {
        int[] f = new int[128];
        for (char c : s.toCharArray()) {
            f[c] += 1;
        }
        char[] res = new char[s.length()];
        int i = 0;
        while (i < s.length()) {
            int maxi = findMaxI(f);
            int freq = f[maxi];
            while (freq > 0) {
                res[i++] = (char) (maxi);
                freq--;
            }
            f[maxi] = 0;
        }
        return new String(res);
    }
}
