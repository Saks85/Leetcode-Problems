class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            else return a[0]-b[0];

        });
        int tot=0;
        for(int i=1; i<points.length; i++){
            int j=i-1;
            int y=-1;
            while (j>=0){
                if (points[i][1]<=points[j][1]){
                    if(y==-1 || y> points[j][1] || y<points[i][1]){
                        tot++;
                        if(y==-1 ||(y>points[j][1])){
                            y=points[j][1];
                        }
                    }
                }
                j--;
            }
        }
        return tot;


    }
}
