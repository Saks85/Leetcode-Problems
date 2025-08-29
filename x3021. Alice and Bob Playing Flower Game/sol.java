class Solution {
    public long flowerGame(int n, int m) {
        // Alice wins only if there are odd number of flowers
        // below way to get number of odd combination
        //take a odd num form n and an even from m and similar to m and n and add them
        long x=(n+1)/2;
        long y= (m+1)/2;//no. of odds 

        long X= n/2;
        long Y= m/2; //no. of evens

        return (x*Y)+(X*y);

        // or simply return (long)(m*n)/2;

    }
}
