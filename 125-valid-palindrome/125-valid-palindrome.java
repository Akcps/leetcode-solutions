class Solution {
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            char c1 = s.charAt(low);
            if (c1 >= 'A' && c1 <= 'Z') {
                c1 = Character.toLowerCase(c1);
            }
            if (!((c1 >= 'a' && (c1 <= 'z')) || (c1 >= '0' && c1 <= '9'))) {
                low++;
                continue;
            }
            
            char c2 = s.charAt(high);
            if (c2 >= 'A' && c2 <= 'Z') {
                c2 = Character.toLowerCase(c2);
            }
            if (!((c2 >= 'a' && (c2 <= 'z')) || (c2 >= '0' && c2 <= '9'))) {
                high--;
                continue;
            }
             
            if (c1 != c2) {
                return false;
            }
            
            low++;
            high--;
        }
        return true;
    }
}