/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
 * Memory Usage: 33.1 MB, less than 5.09% of Java online submissions for Hamming Distance.
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int dist = 0;
        while (xor != 0) {
            if (xor % 2 == 1) {
                dist++;
            }
            xor = xor >> 1;
        }
        return dist;
    }
}