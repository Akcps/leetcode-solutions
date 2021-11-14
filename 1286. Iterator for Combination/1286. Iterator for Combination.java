/**
 * Runtime: 14 ms, faster than 77.72% of Java online submissions for Iterator for Combination.
 * Memory Usage: 41.2 MB, less than 57.51% of Java online submissions for Iterator for Combination.
 */

class CombinationIterator {

    private List<String> combinations;
    private int currentIndex;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        generateCombinations(characters, 0, new StringBuilder(), combinationLength);
        currentIndex = 0;
    }

    public String next() {
        return combinations.get(currentIndex++);
    }

    public boolean hasNext() {
        return currentIndex < combinations.size();
    }

    public void generateCombinations(String characters, int index, StringBuilder sb, int maxLength) {
        if (sb.length() == maxLength) {
            combinations.add(sb.toString());
            return;
        }

        for (int i = index; i < characters.length(); i++) {
            sb.append(characters.charAt(i));
            generateCombinations(characters, i + 1, sb, maxLength);
            sb.setLength(sb.length() - 1);
        }

    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */