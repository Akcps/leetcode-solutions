/**
 * Runtime: 29 ms, faster than 35.33% of Java online submissions for Regular Expression Matching.
 * Memory Usage: 37.1 MB, less than 98.98% of Java online submissions for Regular Expression Matching.
 */
class Solution {
    public boolean isMatch(String s, String p) {
        return isProperMatch(s, p, 0, 0);
    }

    private boolean isProperMatch(String s, String p, int sIndex, int pIndex) {
        if (sIndex >= s.length() && pIndex >= p.length()) {
            return true;
        }

        if (pIndex >= p.length()) {
            return false;
        }

        boolean match = sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            return isProperMatch(s, p, sIndex, pIndex + 2) ||  // don't use *
                    (match && isProperMatch(s, p, sIndex + 1, pIndex)); // use *
        }
        if (match) {
            return isProperMatch(s, p, sIndex + 1, pIndex + 1);
        }
        return false;

    }
}

/**
 * Memoization - Top Down
 * Runtime: 6 ms, faster than 45.54% of Java online submissions for Regular Expression Matching.
 * Memory Usage: 38.7 MB, less than 65.59% of Java online submissions for Regular Expression Matching.
 */
class Solution {
    public boolean isMatch(String s, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        return isProperMatch(s, p, 0, 0, dp);
    }

    private boolean isProperMatch(String s, String p, int sIndex, int pIndex, Map<String, Boolean> dp) {
        String key = "" + sIndex + "," + pIndex;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (sIndex >= s.length() && pIndex >= p.length()) {
            return true;
        }

        if (pIndex >= p.length()) {
            return false;
        }

        boolean match = sIndex < s.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.');
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
            dp.put(key, isProperMatch(s, p, sIndex, pIndex + 2, dp) ||  // don't use *
                    (match && isProperMatch(s, p, sIndex + 1, pIndex, dp))); // use *
            return dp.get(key);
        }
        if (match) {
            dp.put(key, isProperMatch(s, p, sIndex + 1, pIndex + 1, dp));
            return dp.get(key);
        }

        dp.put(key, false);
        return false;

    }
}

/**
 * Memoziation - Bottom Up
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
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (pattern[j - 2] == '.' || pattern[j - 2] == text[i - 1]) {
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