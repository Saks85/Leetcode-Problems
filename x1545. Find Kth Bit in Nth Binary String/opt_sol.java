class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        
        int length = (1 << n) - 1; // This is 2^n - 1
        int mid = length / 2 + 1;
        
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            // Find the bit in the mirrored position and flip it
            char mirroredBit = findKthBit(n - 1, length - k + 1);
            return (mirroredBit == '0') ? '1' : '0';
        }
    }
}
