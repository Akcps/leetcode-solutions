class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] firstMatch = new int[10];
        int[] secondMatch = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - 48;
            int g = guess.charAt(i) - 48;
            if (s == g) {
                bulls++;
            } else  {
                firstMatch[s]++;
                secondMatch[g]++;
            }
        }
        
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secondMatch[i], firstMatch[i]);
        }
        return "" + bulls + "A" + cows + "B";
    }
}