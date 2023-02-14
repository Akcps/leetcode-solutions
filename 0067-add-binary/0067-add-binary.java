class Solution {
    public String addBinary(String a, String b) {
        
        int index = 0;
        Stack<Character> stack = new Stack<>();
        char carry = '0';
        
        while (index < Math.max(a.length(), b.length())) {
            char aChar = '0';
            char bChar = '0';
            
            if (index < a.length()) {
              aChar = a.charAt(a.length() - index - 1);
            }
            
            if (index < b.length()) {
              bChar = b.charAt(b.length() - index - 1);
            }
            
            char[] op = addBinaryChar(aChar, bChar, carry);
            carry = op[1];
            
            stack.push(op[0]);
            
            index++;
        }
        if (carry == '1') {
            stack.push(carry);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            char c = stack.pop();
            sb.append(c);
        }
        return sb.toString();
    }
    
    private char[] addBinaryChar(char a, char b, char carry) {
        int count = 0;
        
        if (a == '1') {
            count++;
        }
        
        if (b == '1') {
            count++;
        }
        
        if (carry == '1') {
            count++;
        }
        
        char newCarry = '0';
        if (count == 2 || count == 3) {
            newCarry = '1';
        }
        
        char res = '0';
        if (count == 1 || count == 3) {
            res = '1';
        }
        
        return new char[]{res, newCarry};
        
    }
}