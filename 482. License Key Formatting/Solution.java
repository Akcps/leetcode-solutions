/**
 * Runtime: 7 ms, faster than 94.15% of Java online submissions for License Key Formatting.
 * Memory Usage: 41.6 MB, less than 6.12% of Java online submissions for License Key Formatting.
 */
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c!= '-') {
                sb.append(Character.toUpperCase(c));
            }
        }
        StringBuilder result = new StringBuilder();
        int start = sb.length() % K;
        int i = 0;
        for (; i < start; i++) {
            result.append(sb.charAt(i));
        }
        if (start > 0 && i != sb.length()) {
            result.append('-');
        }
        int count = 1;
        for (; start < sb.length(); start++) {
            result.append(sb.charAt(start));
            if (count == K && start != sb.length() - 1) {
                result.append('-');
                count = 0;
            }
            count++;
        }
        return result.toString();
    }
}