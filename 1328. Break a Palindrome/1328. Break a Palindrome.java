/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Break a Palindrome.
 * Memory Usage: 36.8 MB, less than 86.33% of Java online submissions for Break a Palindrome.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if (len == 0 || len == 1) {
            return "";
        }
        char[] palindromeArray = palindrome.toCharArray();

        for (int i = 0; i < len / 2; i++) {
            if (palindromeArray[i] != 'a') {
                palindromeArray[i] = 'a';
                return String.valueOf(palindromeArray);
            }
        }
        palindromeArray[len - 1] = 'b';
        return String.valueOf(palindromeArray);
    }
}