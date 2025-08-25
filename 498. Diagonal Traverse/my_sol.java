class Solution {
  //traverse the array and get diagnoal elements and then traverse again to get it in right order
    public int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> ans= new ArrayList<>();
        
        for(int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                if(ans.size()<i+j+1) ans.add(new ArrayList<>());
                ans.get(i+j).add(mat[i][j]);
            }
        }
        int [] res=new int[mat.length*mat[0].length];
        int k=0;
        for (int i=0; i<ans.size(); i++){
            if(i%2!=0){
                for(int j=0; j<ans.get(i).size(); j++){
                    res[k++]=ans.get(i).get(j);
                }
            }
            else{
                for(int j=ans.get(i).size()-1; j>=0; j--){
                    res[k++]=ans.get(i).get(j);
                }
            }
        }
        return res;
    }
}
