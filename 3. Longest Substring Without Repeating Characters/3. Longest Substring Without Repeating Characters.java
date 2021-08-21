/**
 * Runtime: 7 ms, faster than 82.11% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 36.1 MB, less than 99.76% of Java online submissions for Longest Substring Without Repeating Characters.
 * Time Complexity: O (N)
 * Space Complexity: O (N)
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, windowStart = 0;
        Map<Character, Integer> charIndex = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char right = s.charAt(windowEnd);
            if (charIndex.containsKey(right)) {
                windowStart = Math.max(windowStart, charIndex.get(right) + 1);
            }
            charIndex.put(right, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}