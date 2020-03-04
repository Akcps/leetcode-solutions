/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
 * Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
 */
class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;

        while(n != 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit;
            mul *= digit;
        }

        return mul - sum;
    }
}