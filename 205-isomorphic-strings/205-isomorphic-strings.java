class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> leftToRightMap = new HashMap<>();
         Map<Character, Character> rightToLeftMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            char r = t.charAt(i);
             if ((leftToRightMap.containsKey(l) && !rightToLeftMap.containsKey(r)) || (!leftToRightMap.containsKey(l) && rightToLeftMap.containsKey(r))) {
                 return false;
             }
                 
            if (leftToRightMap.containsKey(l) && leftToRightMap.get(l) != r && rightToLeftMap.containsKey(r) && rightToLeftMap.get(r) != l) {
               return false;
            } else {
                leftToRightMap.put(l, r);
                rightToLeftMap.put(r, l);
            }
        }
        return true;
    }
}