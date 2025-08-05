class Solution {
    public int candy(int[] ratings) {
        //the better approach
        int[] left= new int[ratings.length];
        left[0]=1;
        for (int i=1; i<ratings.length; i++){
            if (ratings[i]>ratings[i-1]){
                left[i]=(left[i-1]+1);
            }
            else left[i]=1;
        }
        int sum = Math.max(1,left[ratings.length-1]);
        int cur=1;
        for(int i=ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                cur=(cur+1);
            }
            else cur=1;
            sum+= Math.max(cur, left[i]);
            System.out.println(ratings[i]+" "+cur+" "+left[i]+" "+sum);
        }
        return sum;        
    }
}
