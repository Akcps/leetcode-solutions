/**
 * Runtime: 7 ms, faster than 84.45% of Java online submissions for Valid Palindrome II.
 * Memory Usage: 42.2 MB, less than 5.55% of Java online submissions for Valid Palindrome II.
 */
class Solution {

    public boolean validPalindrome(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0 ; i < ch.length / 2; i++) {
            if (ch[i] != ch[ch.length - 1 - i]) {
                int j = ch.length - i - 1;
                return (isPalindrome(ch, i + 1 , j) || (isPalindrome(ch, i, j - 1)));
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] ch, int low, int high) {
        for (int i = low, j = high; i <= j; i++, j--) {
            if (ch[i] != ch[j]) {
                return false;
            }
        }
        return true;
    }
}