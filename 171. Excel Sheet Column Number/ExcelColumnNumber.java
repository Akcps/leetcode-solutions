/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Number.
 * Memory Usage: 38.5 MB, less than 5.88% of Java online submissions for Excel Sheet Column Number.
 */
class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int a = (ch - 'A') + 1;
            result += Math.pow(26, n - 1) * a;
            n--;
        }
        return result;
    }
}