/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Armstrong Number.
 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Armstrong Number.
 */
class Solution {
    public boolean isArmstrong(int N) {
        int sum = 0;
        int num = N;
        int countDigits = countDigits(N);
        while(num > 0) {
            int rem = num % 10;
            sum += Math.pow(rem, countDigits);
            num /= 10;
        }
        return sum == N;
    }
    private int countDigits(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}