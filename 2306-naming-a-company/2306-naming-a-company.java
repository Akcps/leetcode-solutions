class Solution {
    public long distinctNames(String[] ideas) {
        Set<String>[] strs = getSubstrings(ideas);
        
        long count = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                
                long intersected = 0;
                for (String ideaA: strs[i]) {
                   if (strs[j].contains(ideaA)) {
                       intersected++;
                   }
                }
                count += 2 * (strs[i].size() - intersected) * (strs[j].size() - intersected);
            }
        }
        return count;
    }
    
    private Set<String>[] getSubstrings(String[] ideas) {
        Set<String>[] strs = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            strs[i] = new HashSet<>();
        }
        for (String s: ideas) {
            strs[s.charAt(0) - 'a'].add(s.substring(1));
        }
        return strs;
    }
    
    private Set<Character> getFirstCharacters(String[] ideas) {
        Set<Character> chars = new HashSet<>();
        for (String s: ideas) {
            chars.add(s.charAt(0));
        }
        return chars;
    }
}