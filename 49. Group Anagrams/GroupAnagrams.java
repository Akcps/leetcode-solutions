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