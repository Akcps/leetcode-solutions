/**
 * Runtime: 5 ms, faster than 48.67% of Java online submissions for Remove Outermost Parentheses.
 * Memory Usage: 39 MB, less than 97.29% of Java online submissions for Remove Outermost Parentheses.
 */
class Solution {
    public String removeOuterParentheses(String S) {
        if (S == null) {
            return S;
        }
        Stack<Character> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(')  {
                if (!stack.isEmpty()) {
                    sb.append(ch);
                }
                stack.add(ch);
            }
            if (ch == ')')  {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}