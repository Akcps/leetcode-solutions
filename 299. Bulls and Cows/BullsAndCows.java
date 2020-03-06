/**
 * Runtime: 6 ms, faster than 47.68% of Java online submissions for Bulls and Cows.
 * Memory Usage: 38.6 MB, less than 55.26% of Java online submissions for Bulls and Cows.
 */
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        HashMap<Character, Integer> firstMatch = new HashMap<>();
        HashMap<Character, Integer> secondMatch = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else  {
                firstMatch.put(s, firstMatch.getOrDefault(s, 0) + 1);
                secondMatch.put(g, secondMatch.getOrDefault(g, 0) + 1);
            }
        }

        for (char c: secondMatch.keySet()) {
            cows += Math.min(secondMatch.get(c), firstMatch.getOrDefault(c, 0));
        }
        return "" + bulls + "A" + cows + "B";
    }
}