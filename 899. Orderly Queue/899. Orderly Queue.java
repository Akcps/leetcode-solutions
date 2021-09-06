/**
 * Runtime: 2 ms, faster than 89.72% of Java online submissions for Orderly Queue.
 * Memory Usage: 39.3 MB, less than 33.64% of Java online submissions for Orderly Queue
 */

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 0) {
            return s;
        }
        if (k > 1) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            return new String(chs);
        } else if (k == 1) {
            String ans = s;
            for (int i = 0; i < s.length(); i++) {
                String newOrderStr = s.substring(i) + s.substring(0, i);
                if (newOrderStr.compareTo(ans) < 0) {
                    ans = newOrderStr;
                }
            }
            return ans;
        }
        return s;
    }
}