/**
 * Runtime: 4 ms, faster than 83.98% of Java online submissions for Valid Palindrome.
 * Memory Usage: 39.4 MB, less than 25.00% of Java online submissions for Valid Palindrome.
 */
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                sb.append(ch);
            }
        }
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1))
                return false;
        }
        return true;
    }
}