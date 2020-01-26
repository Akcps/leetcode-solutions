/**
 * Runtime: 1 ms, faster than 44.05% of Java online submissions for Verifying an Alien Dictionary.
 * Memory Usage: 38.3 MB, less than 15.38% of Java online submissions for Verifying an Alien Dictionary.
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isOrdered(words[i], words[i+1], orderMap)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOrdered(String larger, String smaller, Map<Character, Integer> orderMap) {
        int len = Math.min(larger.length(), smaller.length());
        for (int i = 0; i < len; i++) {
            if (orderMap.get(larger.charAt(i)) < orderMap.get(smaller.charAt(i))) {
                return true;
            } else if (orderMap.get(larger.charAt(i)) > orderMap.get(smaller.charAt(i))) {
                return false;
            }
        }
        return larger.length() == len;
    }
}