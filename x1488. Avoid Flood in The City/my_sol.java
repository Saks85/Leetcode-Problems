class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        List<Integer> zeroInd = new ArrayList<>();
        Map<Integer, Integer> filled = new HashMap<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                zeroInd.add(i);
            } else {
                if (filled.containsKey(rains[i])) {
                    if (zeroInd.size() <= 0)
                        return new int[] {};
                    int k = 0;
                  // to see that the zero is not before the required lake got filled
                  // incase we don't have a zero andlake is already filled we return an empty array showing the not possible case
                    while (k < zeroInd.size() && zeroInd.get(k) < filled.get(rains[i])) {
                        k++;
                    }
                    if (k >= zeroInd.size())
                        return new int[] {};
                    ans[zeroInd.get(k)] = rains[i];
                    zeroInd.remove(k);
                }
                filled.put(rains[i], i);
                ans[i] = -1;

            }

        }
        int j = 0;
        while (j < zeroInd.size()) {

            ans[zeroInd.get(j++)] = 1;
        }
        return ans;

    }
}
