/**
 * Runtime: 1 ms, faster than 97.13% of Java online submissions for Decode Ways.
 * Memory Usage: 35.5 MB, less than 100.00% of Java online submissions for Decode Ways.
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] memo = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            memo[i] = -1;
        return numDecoding(s, 0, memo);
    }

    public int numDecoding(String s, int k , int[] memo) {
        if (k == s.length()) {
            return 1;
        }
        if (memo[k] != -1)
            return memo[k];
        int result = 0;
        int d1 = Character.getNumericValue(s.charAt(k));
        if (d1 > 0) {
            result += numDecoding(s, k + 1, memo);
        }
        if (k < s.length() - 1) {
            int d2 = Integer.valueOf(s.substring(k, k + 2));
            if (d2 >= 10 && d2 <= 26) {
                result += numDecoding(s, k + 2, memo);
            }
        }
        memo[k] = result;
        return memo[k];
    }
}