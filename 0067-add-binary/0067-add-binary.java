class Solution {
public String addBinary(String a, String b) {
    
    Stack<Integer> stack = new Stack<>();
    int carry = 0;
    int n = a.length() - 1;
    int m = b.length() - 1;

    while(n >= 0 || m >= 0){
        
        int sum = carry;

        if(n >= 0) sum += a.charAt(n) - 48;
        if(m >= 0) sum += b.charAt(m) - 48;

        carry = sum/2;
        stack.push(sum % 2);

        n--;
        m--;
    }
    if(carry == 1) stack.push(carry);

    String answer = "";
    while(!stack.isEmpty()){
        answer += stack.pop();
    }
    return answer;
    }
}