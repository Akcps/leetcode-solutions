/**
 * Runtime: 12 ms, faster than 49.48% of Java online submissions for Longest Substring with At Most K Distinct Characters.
 * Memory Usage: 41.6 MB, less than 6.38% of Java online submissions for Longest Substring with At Most K Distinct Characters.
 */
class Solution {
    int max = 0;
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> lastOccurrenceMap = new HashMap<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            lastOccurrenceMap.put(ch, right);
            if (lastOccurrenceMap.size() == k + 1) {
                int indexToBeDeleted = Collections.min(lastOccurrenceMap.values());
                lastOccurrenceMap.remove(s.charAt(indexToBeDeleted));
                left = indexToBeDeleted + 1;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}