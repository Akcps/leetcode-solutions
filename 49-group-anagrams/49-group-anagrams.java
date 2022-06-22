class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String s = hash(countLetters(str));
            List<String> values = map.getOrDefault(s, new ArrayList<>());
            values.add(str);
            map.put(s, values);
        }
        return new ArrayList<>(map.values());
    }
    
    private int[] countLetters(String str) {
        int[] count = new int[26];
        for (char s: str.toCharArray()){
            count[s - 97]++;
        }
        return count;
    }
    
    private String hash (int[] count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append('a' + i);
            sb.append(count[i]);
            sb.append('#');
        }
        return sb.toString();
    }
}