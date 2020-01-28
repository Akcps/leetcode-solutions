/**
 * Runtime: 2 ms, faster than 92.37% of Java online submissions for Goat Latin.
 * Memory Usage: 38.1 MB, less than 6.67% of Java online submissions for Goat Latin.
 */
class Solution {
    public String toGoatLatin(String S) {
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        StringBuilder result = new StringBuilder();
        String[] words = S.split(" ");
        int i = 1;
        for (String word: words) {
            StringBuilder newWord = new StringBuilder();
            if (word.length() > 0) {
                if (vowels.contains(word.charAt(0))) {
                    newWord.append(word);

                } else {
                    newWord.append(word.substring(1, word.length()));
                    newWord.append(word.charAt(0));
                }
                newWord.append("ma");
                for (int j = 1; j <= i; j++) {
                    newWord.append('a');
                }
                result.append(newWord);
                result.append(" ");
                i++;
            }
        }
        return result.toString().trim();
    }
}