/**
 * Runtime: 2 ms, faster than 93.16% of Java online submissions for Regular Expression Matching.
 * Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Regular Expression Matching.
 */
class Solution {
    public boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean dp[][] = new boolean[text.length + 1][pattern.length + 1];

        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            if (pattern[i-1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    dp[i][j] = dp[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[text.length][pattern.length];
    }
}