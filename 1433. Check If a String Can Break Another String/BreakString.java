/**
 * Runtime: 32 ms, faster than 100.00% of Java online submissions for Check If a String Can Break Another String.
 * Memory Usage: 51.5 MB, less than 100.00% of Java online submissions for Check If a String Can Break Another String.
 */
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        s1 = sortedString(s1);
        s2 = sortedString(s2);

        boolean flag = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s2.charAt(i) < s1.charAt(i))  {
                flag = false;
            }
        }
        if (!flag) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) < s2.charAt(i))  {
                    return false;
                }
            }
        }
        return true;
    }

    private String sortedString(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}