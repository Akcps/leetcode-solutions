/**
 * Runtime: 14 ms, faster than 65.21% of Java online submissions for Remove All Adjacent Duplicates In String.
 * Memory Usage: 39.3 MB, less than 75.88% of Java online submissions for Remove All Adjacent Duplicates In String.
 */
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && ch == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            char c = stack.pop();
            sb.append(c);
        }
        return sb.toString();
    }
}