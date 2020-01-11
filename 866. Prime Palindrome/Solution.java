/**
 * Runtime: 15 ms, faster than 85.01% of Java online submissions for Prime Palindrome.
 * Memory Usage: 33.5 MB, less than 50.00% of Java online submissions for Prime Palindrome.
 */
class Solution {
    public int primePalindrome(int N) {
        while (true) {
            if (isPalindrome(N) && isPrime(N)) return N;
            N++;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }

    }

    private boolean isPalindrome(int n) {
        if (n < 10)
            return true;
        int ans = 0;
        int N = n;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans == n;
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 4; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}