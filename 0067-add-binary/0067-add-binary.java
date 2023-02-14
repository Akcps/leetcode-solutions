class Solution {
    public String addBinary(String a, String b) {
        
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        
        while (index < Math.max(a.length(), b.length())) {
            int aChar = 0;
            int bChar = 0;
            
            if (index < a.length()) {
              aChar = a.charAt(a.length() - index - 1) - 48;
            }
            
            if (index < b.length()) {
              bChar = b.charAt(b.length() - index - 1) - 48;
            }
            
            int sum = aChar + bChar + carry;
            
            carry = sum / 2;
            
            stack.push(sum % 2);
            
            index++;
        }
        
        if (carry == 1) {
            stack.push(carry);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            int c = stack.pop();
            sb.append(c);
        }
        return sb.toString();
    }
}