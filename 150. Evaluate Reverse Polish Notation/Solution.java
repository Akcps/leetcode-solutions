/**
 * Runtime: 4 ms, faster than 95.80% of Java online submissions for Evaluate Reverse Polish Notation.
 * Memory Usage: 41.5 MB, less than 6.00% of Java online submissions for Evaluate Reverse Polish Notation.
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> stack = new Stack<>();
        for (String s: tokens) {
            if (operators.contains(s)) {
                int a = stack.pop();
                int b = stack.pop();
                int c = 0;
                if (s.equals("+")){
                    c = b + a;
                } else if (s.equals("-")) {
                    c = b - a;
                } else if (s.equals("*")) {
                    c = b * a;
                } else if (s.equals("/")) {
                    c = b / a;
                }
                stack.push(c);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}