class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        final int MOD = 1_000_000_007;
        long maxProduct = 0;

        for (long x = 0; x < (1L << n); x++) {
            long xorA = a ^ x;
            long xorB = b ^ x;
            long product = (xorA % MOD) * (xorB % MOD) % MOD;
            maxProduct = Math.max(maxProduct, product);
        }

        return (int) maxProduct;
    }
}