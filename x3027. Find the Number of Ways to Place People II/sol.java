class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            else return a[0]-b[0];

        });
        int tot=0;
        for(int i=1; i<points.length; i++){
            int j=i-1;
            int y=Integer.MAX_VALUE;
            while (j>=0){
                if (points[i][1]<=points[j][1]){
                    if(y> points[j][1] || y<points[i][1]){
                        tot++;
                        if(y>points[j][1]){
                            y=points[j][1];
                        }
                    }
// reduntant to this form as we aare updating y if y>points[j][i] so y will never be less than points[i][1] thus we can omit the check y<points[i][1];
        //           if (points[i][1] <= points[j][1]) {
        //             if (y > points[j][1]) {
        //                 tot++;
        //                 y = points[j][1];
        //             }
        //         }
                }
                j--;
            }
        }
        return tot;


    }
}

        // for (int i = 1; i < points.length; i++) {
        //     int j = i - 1;
        //     int y = Integer.MAX_VALUE; // fix for negative values
        //     while (j >= 0) {
        //         
        //         j--;
        //     }
        // }
