class Solution {
    public int findComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int todo = N, bit = 1;
        while (todo != 0) {
            N = N ^ bit;
            bit = bit << 1;
            todo = todo >> 1;
        }
        return N;
    }

}