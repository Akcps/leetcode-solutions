/**
 * Runtime: 1 ms, faster than 64.28% of Java online submissions for Backspace String Compare.
 * Memory Usage: 38.2 MB, less than 6.06% of Java online submissions for Backspace String Compare.
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    private String getString(String S) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char s = S.charAt(i);
            if (s == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}


/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
 * Memory Usage: 37.9 MB, less than 6.06% of Java online submissions for Backspace String Compare.
 */
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            if ((i >= 0) != (j >=0) ) {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }
}