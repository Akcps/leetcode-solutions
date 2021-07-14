/**
 * Runtime: 1 ms, faster than 99.64% of Java online submissions for Reverse Words in a String II.
 * Memory Usage: 42.4 MB, less than 55.15% of Java online submissions for Reverse Words in a String II.
 * Time Complexity = O (n)
 * Space Complexity = O(1)
 */

class Solution {
    public void reverseWords(char[] s) {
        int low = 0;
        int high = s.length - 1;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }

        int i = 0;
        while(i < s.length) {
            low = i;
            high = i;
            while(high < s.length && s[high] != ' ' ) {
                high++;
            }
            i = high;
            high--;
            while (low < high) {
                char temp = s[low];
                s[low] = s[high];
                s[high] = temp;
                low++;
                high--;
            }
            if (i < s.length) {
                s[i] = ' ';
                i++;
            }
        }
    }
}