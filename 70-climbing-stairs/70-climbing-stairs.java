class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        int t = 0;
        for (int c = 3; c <= n; c++) {
            t = a + b;
            a = b;
            b = t;
        }
        
        return t;
        
        
    }
}