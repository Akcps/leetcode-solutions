/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Additive Number.
 * Memory Usage: 37.1 MB, less than 14.29% of Java online submissions for Additive Number.
 */
class Solution {
    public boolean isAdditiveNumber(String num) {
        long n1 = 0;
        for (int i = 0; i < num.length() - 1; i++) {
            n1 = n1 * 10 + num.charAt(i) - '0';
            long n2 = 0;
            for (int j = i + 1; j < num.length(); j++) {
                n2 = n2 * 10 + num.charAt(j) - '0';
                if (check(n1, n2, j + 1, num, 2)) {
                    return true;
                }

                if (n2 == 0) {
                    break;
                }
            }
            if (n1 == 0) {
                break;
            }

        }
        return false;
    }

    boolean check(long n1, long n2, int curr, String num, int count) {
        if (curr >= num.length()) {
            if (count >= 3)
                return true;
            return false;
        }
        if (num.charAt(curr) == '0' && n1 + n2 != 0)
            return false;

        long n = 0;
        long target = n1 + n2;
        for (int i = curr; i < num.length(); i++) {
            n = n * 10 + num.charAt(i) - '0';
            if (n == target && check(n2, n, i + 1, num, count + 1))
                return true;
            else if (n > target)
                break;
        }
        return false;
    }
}