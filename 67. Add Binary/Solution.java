/**
 * Runtime: 2 ms, faster than 60.13% of Java online submissions for Add Binary.
 * Memory Usage: 38.8 MB, less than 5.62% of Java online submissions for Add Binary.
 */
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() >= b.length()) {
            return add(a, b);
        }
        return add(b, a);
    }

    private String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1 ; i >= 0; i--, j--) {
            int n1 = Integer.valueOf(num1.charAt(i) - 48);
            int n2 = 0;
            if (j >= 0) {
                n2 = Integer.valueOf(num2.charAt(j) - 48);
            }
            int sum = n1 + n2 + carry;
            carry = sum / 2;
            result.insert(0, String.valueOf(sum % 2));
        }
        if (carry > 0) {
            result.insert(0, String.valueOf(carry));
        }
        return result.toString();
    }

}