/**
 * Runtime: 5 ms, faster than 20.13% of Java online submissions for Beautiful Array.
 * Memory Usage: 40 MB, less than 5.03% of Java online submissions for Beautiful Array.
 */

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            List<Integer> temp = new ArrayList<>();
            for (int e: res) {
                if (2* e - 1 <= n) {
                    temp.add(2 * e - 1);
                }
            }

            for (int e: res) {
                if (2* e <= n) {
                    temp.add(2 * e);
                }
            }
            res = temp;
        }
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = res.get(i);
        }
        return output;
    }
}