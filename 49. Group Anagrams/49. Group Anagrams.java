/**
 * Runtime: 6 ms, faster than 97.13% of Java online submissions for Group Anagrams.
 * Memory Usage: 43 MB, less than 76.02% of Java online submissions for Group Anagrams.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            List<String> list;
            if (map.containsKey(key)) {
                list = map.get(key);
                list.add(str);
            } else {
                list = new ArrayList<>();
                list.add(str);
            }
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}

/**
 * Runtime: 24 ms, faster than 14.69% of Java online submissions for Group Anagrams.
 * Memory Usage: 44.3 MB, less than 12.86% of Java online submissions for Group Anagrams.
 * Time Complexity: O(NK)
 * Space Complexity: O(NK)
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] count = new int[26];
            for(char c: str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('a' + i);
                sb.append('0' + count[i]);
            }
            List<String> values = map.getOrDefault(sb.toString(), new ArrayList<String>());
            values.add(str);
            map.put(sb.toString(), values);
        }
        for (String s: map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }
}