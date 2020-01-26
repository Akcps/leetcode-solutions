/**
 * Runtime: 4 ms, faster than 41.01% of Java online submissions for Add Strings.
 * Memory Usage: 39.9 MB, less than 6.25% of Java online submissions for Add Strings.
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() >= num2.length()) {
            return add(num1, num2);
        }
        return add(num2, num1);
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
            carry = sum / 10;
            result.insert(0, String.valueOf(sum % 10));
        }
        if (carry > 0) {
            result.insert(0, String.valueOf(carry));
        }
        return result.toString();
    }
}