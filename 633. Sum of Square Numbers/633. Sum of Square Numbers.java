/**
 * Runtime: 2 ms, faster than 93.87% of Java online submissions for Sum of Square Numbers.
 * Memory Usage: 35.6 MB, less than 77.31% of Java online submissions for Sum of Square Numbers.
 */

class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                left++;
            } else {
                right--;
            }

        }
        return false;

    }
}