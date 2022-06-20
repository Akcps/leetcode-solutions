class Solution {
    public boolean isSubsequence(String s, String t) {
       return recursion(s, 0, t, 0);
    }
    
    public boolean recursion(String s, int i, String t, int j) {
        if (i == s.length()) {
            return true;
        }
        if (j == t.length()) {
            return false;
        }
        if (s.charAt(i) == t.charAt(j)) {
            return recursion(s, i + 1, t, j + 1);
        } else {
             return recursion(s, i, t, j + 1);
        }
    }
}