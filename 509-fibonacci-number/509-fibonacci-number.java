class Solution {
    public int fib(int n) {
        int a = 0;
        int b = 1;
        
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int t = 0;
        for (int c = 2; c <= n; c++) {
            t = a + b;
            a = b;
            b = t;
        }
        
        return t;
    }
}