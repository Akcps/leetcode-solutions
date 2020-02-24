/**
 * Runtime: 5 ms, faster than 87.11% of Java online submissions for Find Words That Can Be Formed by Characters.
 * Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Find Words That Can Be Formed by Characters.
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] charsArray = new int[26];
        for (char c: chars.toCharArray()) {
            charsArray[c - 'a']++;
        }

        for(String word: words) {
            boolean flag = false;
            int[] charsArrayCopy = Arrays.copyOf(charsArray, 26);
            for (char c: word.toCharArray()) {
                charsArrayCopy[c - 'a']--;
                if (charsArrayCopy[c - 'a'] < 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                count += word.length();
            }
        }
        return count;
    }
}