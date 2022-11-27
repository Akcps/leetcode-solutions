class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String s: strs) {
            String hashStr = getHashString(s);
            if (anagrams.containsKey(hashStr)) {
                anagrams.get(hashStr).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                anagrams.put(hashStr, newList);
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (String key: anagrams.keySet()) {
            result.add(anagrams.get(key));
        }
        return result;
    }
    
    private String getHashString(String str){
        int[] ch = new int[26];
        for(char c: str.toCharArray()) {
            ch[c - 'a']++;
        }
        
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            s.append('a' + i);
            s.append("" + ch[i] + ":");
        }
        return s.toString();
    }
}