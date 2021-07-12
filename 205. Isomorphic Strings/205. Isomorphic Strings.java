/**
Runtime: 8 ms, faster than 53.62% of Java online submissions for Isomorphic Strings.
Memory Usage: 40.2 MB, less than 6.32% of Java online submissions for Isomorphic Strings.
 Time Complexity = O (n)
 Space Complexity = O (n)
 **/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (charMap.containsKey(c1)) {
                if (c2 != charMap.get(c1)) {
                    return false;
                }
            } else {
                if(set.contains(c2)) {
                    return false;
                }
                set.add(c2);
                charMap.put(c1, c2);
            }
        }
        return true;
    }
}