/**
 * Runtime: 2 ms, faster than 89.54% of Java online submissions for Make The String Great.
 * Memory Usage: 37.6 MB, less than 87.34% of Java online submissions for Make The String Great.
 */

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (!stack.isEmpty() && Character.toUpperCase(ch) == stack.peek()) {
                    stack.pop();
                    continue;
                }
            }
            if (ch >= 'A' && ch <= 'Z') {
                if (!stack.isEmpty() && Character.toLowerCase(ch) == stack.peek()) {
                    stack.pop();
                    continue;
                }
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