/**
 * Runtime: 1 ms, faster than 63.49% of Java online submissions for Implement strStr().
 * Memory Usage: 43.4 MB, less than 6.10% of Java online submissions for Implement strStr().
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.equals(needle)) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}