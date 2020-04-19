/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
 * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
 */
class Solution {
    public int numberOfSteps (int num) {
        if (num == 1) {
            return 1;
        }
        if (num % 2 != 0) {
            return 2 + numberOfSteps(num/2);
        } else {
            return  1 + numberOfSteps(num/2);
        }
    }
}