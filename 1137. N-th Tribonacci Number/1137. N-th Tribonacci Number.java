/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
 * Memory Usage: 35.3 MB, less than 97.02% of Java online submissions for N-th Tribonacci Number.
 */

class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        for (int i = 3; i <= n; i++) {
            int s = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = s;
        }
        return t2;
    }
}