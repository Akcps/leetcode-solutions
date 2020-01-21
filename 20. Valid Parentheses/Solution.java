/**
 * Runtime: 1 ms, faster than 98.56% of Java online submissions for Valid Parentheses.
 * Memory Usage: 40.7 MB, less than 5.06% of Java online submissions for Valid Parentheses.
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();
        for(int i= 0; i< ch.length; i++) {
            if (ch[i] == ')')
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            else if (ch[i] == ']')
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            else if (!stack.isEmpty() && ch[i] == '}')
                if (stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            if (ch[i] =='(' || ch[i]=='{' || ch[i] =='[')
                stack.push(ch[i]);
        }
        if (!stack.isEmpty())
            return false;
        return true;
    }
}