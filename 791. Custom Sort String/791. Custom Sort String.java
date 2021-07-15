/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Custom Sort String.
 * Memory Usage: 37.1 MB, less than 76.53% of Java online submissions for Custom Sort String.
 * Time Complexity: O (n)
 * Space Complexity: O (n)
 */
class Solution {
    public String customSortString(String order, String str) {
        int[] count = new int[26];
        for (char ch: str.toCharArray()) {
            count[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: order.toCharArray()) {
            if (count[ch - 'a'] > 0) {
                for (int i = 0; i < count[ch - 'a']; i++) {
                    sb.append(ch);
                }
                count[ch - 'a'] = 0;
            }
        }
        for (int j = 0 ; j < 26; j++) {
            for (int i = 0; i < count[j]; i++) {
                sb.append((char)(j +'a'));
            }
        }
        return sb.toString();
    }
}

/**
 * Runtime: 2 ms, faster than 45.57% of Java online submissions for Custom Sort String.
 * Memory Usage: 37 MB, less than 76.08% of Java online submissions for Custom Sort String.
 * Time Complexity: O (n)
 * Space Complexity: O (n)
 */

class Solution {
    public String customSortString(String order, String str) {
        List<Character> chars = new ArrayList<>();
        for (char ch: order.toCharArray()) {
            chars.add(ch);
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: chars) {
            if (map.containsKey(ch)) {
                for (int i = 0; i < map.get(ch); i++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for (char ch: map.keySet()) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}