class Solution {
    // nCk % p using Lucas theorem (p is prime)
    private int nCrModP(int n, int r, int p) {
        if (r > n) return 0;
        int res = 1;
        while (n > 0 || r > 0) {
            int ni = n % p;
            int ri = r % p;
            if (ri > ni) return 0;
            res = (res * smallNCr(ni, ri, p)) % p;
            n /= p;
            r /= p;
        }
        return res;
    }

    // Small nCr where n, r < p
    private int smallNCr(int n, int r, int p) {
        if (r > n) return 0;
        int num = 1, den = 1;
        for (int i = 0; i < r; i++) {
            num = (num * (n - i)) % p;
            den = (den * (i + 1)) % p;
        }
        // Fermat inverse since p is prime
        return (num * pow(den, p - 2, p)) % p;
    }

    private int pow(int a, int b, int mod) {
        long res = 1, x = a;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * x) % mod;
            x = (x * x) % mod;
            b >>= 1;
        }
        return (int) res;
    }

    // Solve x ≡ a (mod 2), x ≡ b (mod 5)
    private int crt(int a, int b) {
        // Possible values modulo 10 are 0..9
        for (int x = 0; x < 10; x++) {
            if (x % 2 == a && x % 5 == b) return x;
        }
        return 0; // shouldn't happen
    }

    public int triangularSum(int[] nums) {
        int n = nums.length - 1;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int c2 = nCrModP(n, i, 2);  // binomial mod 2
            int c5 = nCrModP(n, i, 5);  // binomial mod 5
            int coeff = crt(c2, c5);    // combine to mod 10
            sum = (sum + coeff * nums[i]) % 10;
        }
        return sum;
    }
}
