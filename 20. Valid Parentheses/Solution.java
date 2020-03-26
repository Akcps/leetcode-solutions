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
        return stack.isEmpty();
    }
}

/**
 * Runtime: 1 ms, faster than 98.66% of Java online submissions for Valid Parentheses.
 * Memory Usage: 37.8 MB, less than 5.06% of Java online submissions for Valid Parentheses.
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();
        for(int i= 0; i< ch.length; i++) {
            if (map.containsKey(ch[i]))  {
                if (!stack.isEmpty() && stack.peek() == map.get(ch[i]))
                    stack.pop();
                else
                    return false;
            }
            if (ch[i] =='(' || ch[i]=='{' || ch[i] =='[')
                stack.push(ch[i]);
        }
        return stack.isEmpty();
    }
}