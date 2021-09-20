class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int numDistinct(String s, String t) {
        return countWays(s, t, 0, 0);
    }

    private int countWays(String s, String t, int i, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }
        String index = i + "," + j;
        if (map.containsKey(index)) {
            return map.get(index);
        }
        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res = countWays(s, t, i + 1, j + 1) + countWays(s, t, i + 1, j);
        } else {
            res = countWays(s, t, i + 1, j);
        }
        map.put(index, res);
        return map.get(index);
    }
}