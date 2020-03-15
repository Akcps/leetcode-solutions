/**
 * Runtime: 23 ms, faster than 39.64% of Java online submissions for Find All Anagrams in a String.
 * Memory Usage: 41.2 MB, less than 6.00% of Java online submissions for Find All Anagrams in a String.
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<Integer>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return indices;
        }
        findAnagrams(s, p, indices);
        return indices;
    }

    private void findAnagrams(String s, String p, List<Integer> indices) {
        Map<Character, Integer> pCount = new HashMap<>();

        for (char c: p.toCharArray())
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);

        int windowStart = 0;
        int matched = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (pCount.containsKey(rightChar)) {
                pCount.put(rightChar, pCount.get(rightChar) - 1);
                if (pCount.get(rightChar) == 0) {
                    matched++;
                }
            }
            if (pCount.keySet().size() == matched) {
                indices.add(windowStart);
            }
            if (windowEnd >= p.length() - 1) {
                char leftChar = s.charAt(windowStart);
                if (pCount.containsKey(leftChar)) {
                    if (pCount.get(leftChar) == 0) {
                        matched--;
                    }
                    pCount.put(leftChar, pCount.get(leftChar) + 1);
                }
                windowStart++;
            }
        }
    }
}