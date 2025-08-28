class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n= grid.length;
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //mp.put(i-j,mp.getOrDefault(i-j,new ArrayList<>()).add(grid[i][j]));
                //this won't work as add returns a boolean which is passed to put function

                ArrayList<Integer> list = mp.getOrDefault(i - j, new ArrayList<>());
                list.add(grid[i][j]);
                mp.put(i - j, list); //correct way

                //or can be done using computeIfAbsent
                //mp.computeIfAbsent(i - j, k -> new ArrayList<>()).add(grid[i][j]);

            }
        }
        for(Integer k: mp.keySet()){
            Collections.sort(mp.get(k));
            System.out.println(k+" "+ mp.get(k));
        }
        int ele;
        ArrayList<Integer> temp;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp=mp.get(i-j);
                if(i-j<0){
                    ele= temp.get(0);
                    temp.remove(0);
                }
                else {
                    ele= temp.get(temp.size()-1);
                    temp.remove(temp.size()-1);
                }
                grid[i][j]=ele;
            }
        }
        return grid;
    }
}
