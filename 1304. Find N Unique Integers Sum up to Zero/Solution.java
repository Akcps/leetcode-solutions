/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
 * Memory Usage: 38.1 MB, less than 100.00% of Java online submissions for Find N Unique Integers Sum up to Zero.
 */
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int i = 0;
        int x = n;
        while (i < n - 1) {
            result[i++] = x;
            result[i++] = -x;
            x--;
        }
        if (n % 2 != 0) {
            result[n-1] = 0;
        }
        return result;
    }
}