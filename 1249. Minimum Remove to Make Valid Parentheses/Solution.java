/**
 * Runtime: 21 ms, faster than 68.35% of Java online submissions for Minimum Remove to Make Valid Parentheses.
 * Memory Usage: 42.2 MB, less than 100.00% of Java online submissions for Minimum Remove to Make Valid Parentheses.
 */
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = removeUnbalancedParenthesis(s, '(', ')');
        result = removeUnbalancedParenthesis(result.reverse(), ')', '(');
        return result.reverse().toString();
    }

    private StringBuilder removeUnbalancedParenthesis(CharSequence s, char open, char close) {
        StringBuilder result = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == open) {
                balance++;
            } else if (c == close) {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }
            result.append(c);
        }
        return result;
    }
}