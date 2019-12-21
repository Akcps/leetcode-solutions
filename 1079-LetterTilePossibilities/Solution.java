/**
 * Runtime: 28 ms, faster than 32.16% of Java online submissions for Letter Tile Possibilities.
 * Memory Usage: 39.3 MB, less than 100.00% of Java online submissions for Letter Tile Possibilities.
 */
class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> strings = new HashSet<String>();
        boolean[] used = new boolean[tiles.length()];
        numTilePossibilities(tiles, new StringBuilder(), strings, used);
        return strings.size();
    }

    private void numTilePossibilities(String tiles, StringBuilder s, Set<String> strings, boolean[] used) {
        if (s.length() > 0) {
            strings.add(new String(s));
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                s.append(tiles.charAt(i));
                numTilePossibilities(tiles, s, strings, used);
                s.deleteCharAt(s.length()-1);
                used[i] = false;
            }
        }
    }
}