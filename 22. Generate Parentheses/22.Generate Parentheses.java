/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
 * Memory Usage: 38.9 MB, less than 86.04% of Java online submissions for Generate Parentheses.
 */
class Solution {
    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            backtrack(sb.append('('), open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            backtrack(sb.append(')'), open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}