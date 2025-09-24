class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<Integer> prev = new ArrayList<>();
        int s=0;
        for (int i = 0; i < m; i++) {
            s = triangle.get(i).size();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < s; j++) {
                if (i == 0 && j == 0) {
                    temp.add(triangle.get(i).get(j));
                } else {
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    if (j < s - 1)
                        up = prev.get(j);
                    if (j > 0)
                        left = prev.get(j - 1);
                    temp.add(Math.min(up, left) + triangle.get(i).get(j));

                }
                
            }
            prev = new ArrayList<>(temp);

        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s; i++) {
            min = Math.min(min, prev.get(i));
        }
        return min;
    }
}
