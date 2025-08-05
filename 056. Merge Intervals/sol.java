class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]); // using lambda expression
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < start) {
                ans.add(new int[] { start, end });
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], arr[i][1]);
            }
        }
        int [][] fin= new int[ans.size()][2];
        for (int i=0; i<ans.size(); i++){
            fin[i]=ans.get(i);
        }
        return fin;
    }
    
}
