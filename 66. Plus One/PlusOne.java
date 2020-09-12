/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
 * Memory Usage: 38 MB, less than 65.16% of Java online submissions for Plus One.
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + carry;
            if (i == digits.length - 1) {
                num++;
            }
            if (num >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            res[i+1] = num % 10;
        }
        if (carry == 1) {
            res[0] = 1;
        }
        if (res[0] == 0) {
            for (int i = 1; i < res.length; i++) {
                digits[i-1] = res[i];
            }
            return digits;
        }
        return res;
    }
}