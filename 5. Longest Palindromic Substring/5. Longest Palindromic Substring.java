/**
 * Runtime: 37 ms, faster than 41.56% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 37.4 MB, less than 79.44% of Java online submissions for Longest Palindromic Substring.
 */
class Solution {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int startIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int k = 2; k <= s.length(); k++) {
            for (int i = 0; i <= s.length() - k ; i++) {
                int j = i + k - 1;
                if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || k == 2) ) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen =  j - i + 1;
                        startIndex = i;
                    }
                }
            }
        }
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = 0; j < s.length(); j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return s.substring(startIndex, startIndex + maxLen);
    }
}

/**
 * Runtime: 23 ms, faster than 90.34% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 38.9 MB, less than 82.62% of Java online submissions for Longest Palindromic Substring.
 * Time Complexity: O (N*N)
 * Space Complexity: O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}