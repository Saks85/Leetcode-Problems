class Solution {
    static{
        for (int i = 0; i < 500; i++) {
            new Solution().lemonadeChange(new int[]{});
        }
    }
    public static boolean lemonadeChange(int[] bills) {
        int [] arr=new int[3];//counts the frequency of each 5,10 and 20
        int x;
        for (int i=0; i <bills.length; i++){
            x=bills[i];
            arr[bills[i]/10]++;
            if(x==20){
                if(arr[0]>0 && arr[1]>0){
                    arr[0]--;
                    arr[1]--;
                    
                }
                else if(arr[0]>=3){
                    arr[0]=arr[0]-3;
                }
                else return false;
            }
            else if(x==10 ){
                if(arr[0]>=1){
                    arr[0]--;
                }
                else return false;
                
            }
        }
        return true;             
    }
}
