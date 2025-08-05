class Solution {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals before newInterval (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Step 2: Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);  // expand start
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);  // expand end
            i++;
        }
        result.add(newInterval);  // add merged interval

        // Step 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i++]);
        }

        // Convert result list to array
        return result.toArray(new int[result.size()][]);
    }
}
