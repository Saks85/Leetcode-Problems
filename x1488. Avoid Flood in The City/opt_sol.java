// TC: o(n logn ) my sol TC: o(n^2)
// we used a treeset.higher func to get the required element instead of linear search which improved out sol
// lin serach is o(n) and treeset.higher is o(logn) => o(nlogn) TC 

import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                // Store the index of dry day
                dryDays.add(i);
                ans[i] = 1; // default, might change later
            } else {
                ans[i] = -1; // raining day
                if (full.containsKey(lake)) {
                    // Find the next available dry day > last filled index
                    Integer dry = dryDays.higher(full.get(lake));
                    if (dry == null)
                        return new int[0]; // cannot prevent flood
                    ans[dry] = lake; // dry this lake on that dry day
                    dryDays.remove(dry);
                }
                // Mark this lake as full on current day
                full.put(lake, i);
            }
        }
        return ans;
    }
}
