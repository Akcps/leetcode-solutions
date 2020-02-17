/**
 * Runtime: 6 ms, faster than 15.68% of Java online submissions for String Compression.
 * Memory Usage: 40.6 MB, less than 6.82% of Java online submissions for String Compression.
 */
class Solution {
    public int compress(char[] chars) {
        int count = 0;
        char old = chars[0];
        int oldPosition = 0;
        int i;
        int charPos = 0;
        for (i = 1; i < chars.length; i++) {
            if (chars[i] != old) {
                int charCount = i - oldPosition;
                if (charCount > 1) {
                    chars[charPos++] = old;
                    for (char c: ("" + charCount).toCharArray()) {
                        chars[charPos++] = c;
                        count++;
                    }
                    count ++;
                } else {
                    chars[charPos++] = old;
                    count++;
                }
                oldPosition = i;
                old = chars[i];
            }
        }
        int charCount = i - oldPosition;
        if (charCount > 1) {
            chars[charPos++] = old;
            for (char c: ("" + charCount).toCharArray()) {
                chars[charPos++] = c;
                count++;
            }
            count ++;
        } else {
            chars[charPos++] = old;
            count++;
        }
        return count;
    }
}