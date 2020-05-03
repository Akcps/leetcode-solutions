/**
 * Runtime: 1 ms, faster than 50.00% of Java online submissions for Kids With the Greatest Number of Candies.
 * Memory Usage: 39.8 MB, less than 100.00% of Java online submissions for Kids With the Greatest Number of Candies.
 */
class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy: candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            result.add(extraCandies + candies[i] >= max);
        }
        return result;
    }
}