class Solution {
    private int counter(int n) {
        //this is a method to get signatures of a number
        //each digit has a unique signature so signature of 128,218,821... will be same
        int count = 0;
        while (n > 0) {
            count += Math.pow(10, n % 10); // unique value for each digit
            n /= 10;
        }
        return count;
    }

    public boolean reorderedPowerOf2(int n) {
        int target = counter(n);

        // here we check signatures of all powers of 2 up to 1 billion
        for (int i = 0; i < 31; i++) {
            if (counter(1 << i) == target) {
                return true;
            }
        }
        return false;
    }
}
