/**
 * Runtime: 1 ms, faster than 46.89% of Java online submissions for Letter Combinations of a Phone Number.
 * Memory Usage: 41.9 MB, less than 6.16% of Java online submissions for Letter Combinations of a Phone Number.
 */
class Solution {

    Map<Character, List<Character>> charMap = new HashMap<Character, List<Character>>();

    private void init() {
        List<Character> chars = Arrays.asList('a', 'b', 'c');
        charMap.put('2', chars);
        chars = Arrays.asList('d', 'e', 'f');
        charMap.put('3', chars);
        chars = Arrays.asList('g', 'h', 'i');
        charMap.put('4', chars);
        chars = Arrays.asList('j', 'k', 'l');
        charMap.put('5', chars);
        chars = Arrays.asList('m', 'n', 'o');
        charMap.put('6', chars);
        chars = Arrays.asList('p', 'q', 'r', 's');;
        charMap.put('7', chars);
        chars = Arrays.asList('t', 'u', 'v');
        charMap.put('8', chars);
        chars = Arrays.asList('w', 'x', 'y', 'z');
        charMap.put('9', chars);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();
        init();
        List<String> letters = new ArrayList<>();
        letterCombinations(digits, 0, new StringBuilder(), letters);
        return letters;
    }

    private void letterCombinations(String digits, int position, StringBuilder st, List<String> letters) {
        if (position == digits.length()) {
            letters.add(st.toString());
            return;
        }
        char ch = digits.charAt(position);
        for (char c: charMap.get(ch)) {
            letterCombinations(digits, position + 1, st.append(c), letters);
            st.deleteCharAt(position);
        }
    }
}