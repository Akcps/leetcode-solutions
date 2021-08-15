/**
 * Runtime: 9 ms, faster than 71.82% of Java online submissions for Minimum Window Substring.
 * Memory Usage: 38.7 MB, less than 98.97% of Java online submissions for Minimum Window Substring.
 * Time Complexity: O (N)
 * Space Complexity: O (N)
 */

class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int matched = 0;
        int minStart = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        for (char c : t.toCharArray())
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);

        int windowStart = 0;
        int windowEnd = 0;

        while (windowEnd < s.length()) {
            char rightChar = s.charAt(windowEnd);
            if (charFreq.containsKey(rightChar)) {
                charFreq.put(rightChar, charFreq.get(rightChar) - 1);

                if (charFreq.get(rightChar) >= 0)
                    matched++;
            }

            while (matched == t.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    minStart = windowStart;
                }
                char leftChar = s.charAt(windowStart);
                if (charFreq.containsKey(leftChar)) {
                    if (charFreq.get(leftChar) == 0) {
                        matched--;
                    }
                    charFreq.put(leftChar, charFreq.get(leftChar) + 1);
                }
                windowStart++;
            }
            windowEnd++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
}