class Solution {
    public int smallestNumber(int n) {
        int i =0;
        while (i<=10){
            if ((1<<i)-1>=n) return (1<<i)-1;
            i++;
        }
        return 1023; //dummy
    }
}
