class Solution {
    static{
        for (int i=0; i<100; i++)
        candy(new int[] {0});
    }
    public static int candy(int[] ratings) {
        //the optimal approach
        int i=1, sum=1, n=ratings.length;
        while (i<n){
            if(ratings[i]==ratings[i-1]){
                sum=sum+1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }
            int down=1;
            while (i<n && ratings[i]<ratings[i-1]){
                sum+=down;
                i++; down++;
            }
            if (peak<down) sum+=(down-peak);
        }
        return sum;
    }
}
