class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int x= numBottles;
        int count =x;//initially drank these bottles
        
        while (x>= numExchange){
            
            int y= x%numExchange;//no. of empty bottles that can't be exchanged
            
            x=x/numExchange ; // new filled bottles we got on exchanging

            count+= x; //drank x bottles

            //System.out.println(count+" "+x);

            x=x+y; // we have these many number of empty bottles now

        }
        return (count);
        
    }
}
