/**
 * Runtime: 6 ms, faster than 100.00% of Java online submissions for Palindrome Number.
 * Memory Usage: 36.4 MB, less than 5.02% of Java online submissions for Palindrome Number.
 */
class Solution {
    public boolean isPalindrome(int x) {
        int y = x;
        if (x < 0){
            return false;
        }
        int sum = 0;
        while (x > 0){
            sum = (sum * 10) + (x % 10);
            x = x / 10;
        }
        return sum == y;

    }
}