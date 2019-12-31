/**
 * Runtime: 19 ms, faster than 33.42% of Java online submissions for Is Subsequence.
 * Memory Usage: 49.3 MB, less than 100.00% of Java online submissions for Is Subsequence.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals(""))
            return true;
        if (s.length() > t.length())
            return false;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(index) == t.charAt(i))
                index++;

            if (index == s.length())
                return true;

        }
        return false;
    }
}


/**
 * Runtime: 3 ms, faster than 90.67% of Java online submissions for Is Subsequence.
 * Memory Usage: 49.7 MB, less than 96.00% of Java online submissions for Is Subsequence.
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        while (i < s.length()) {
            if ( t.indexOf(s.charAt(i)) >= 0){
                t = t.substring(t.indexOf(s.charAt(i)) + 1);
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}


