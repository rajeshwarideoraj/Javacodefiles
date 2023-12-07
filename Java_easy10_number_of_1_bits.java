public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            count += n & 1; // Check the rightmost bit
            n >>>= 1;      // Unsigned right shift
        }
        
        return count;
    }
}