class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for(char ch: s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        boolean containsOdd = false;
        int len = 0;
        for (char c: count.keySet()) {
            int v = count.get(c);
            if (v % 2 == 1) {
                containsOdd = true;
                len += v - 1;
            } else {
                len += v;
            }
        }
        return containsOdd ? len + 1: len;
    }
}