/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Unique Morse Code Words.
 * Memory Usage: 37.4 MB, less than 5.26% of Java online submissions for Unique Morse Code Words.
 */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] moores = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<String>();
        for (String word: words) {
            StringBuilder sb = new StringBuilder();
            for (char ch: word.toCharArray()) {
                int index = ch - 'a';
                sb.append(moores[index]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}