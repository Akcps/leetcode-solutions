/**
 * Runtime: 1 ms, faster than 74.69% of Java online submissions for Slowest Key.
 * Memory Usage: 38.9 MB, less than 83.54% of Java online submissions for Slowest Key.
 */

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] maxDuration = new int[26];
        int previousReleaseTime = 0;
        for (int i = 0; i < keysPressed.length(); i++) {
            int duration = releaseTimes[i] - previousReleaseTime;
            char ch = keysPressed.charAt(i);
            maxDuration[ch - 'a'] = Math.max(maxDuration[ch - 'a'], duration);
            previousReleaseTime = releaseTimes[i];
        }
        int max = Integer.MIN_VALUE;
        char maxChar = 'a';
        for (int i = 0; i < 26; i++) {

            if (max <= maxDuration[i]) {
                max = maxDuration[i];
                maxChar = (char) ('a' + i);
            }
        }
        return maxChar;
    }
}