/**
 * Runtime: 8 ms, faster than 42.96% of Java online submissions for Ugly Number II.
 * Memory Usage: 40.8 MB, less than 9.09% of Java online submissions for Ugly Number II.
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[1690];
        ugly[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < 1690; i++) {
            int nextUgly = Math.min(ugly[i2] * 2, Math.min(ugly[i3] * 3, ugly[i5] * 5));
            if (nextUgly == ugly[i2] * 2) {
                i2++;
            }
            if (nextUgly == ugly[i3] * 3) {
                i3++;
            }
            if (nextUgly == ugly[i5] * 5) {
                i5++;
            }

            ugly[i] = nextUgly;
        }
        return ugly[n-1];
    }
}