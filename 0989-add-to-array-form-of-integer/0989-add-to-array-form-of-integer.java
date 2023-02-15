class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        
        int idx = num.length - 1;
        int carry = 0;
        
        while (k > 0 || idx >= 0) {
            int kLastDigit = 0;
            int numDigit = 0;
            
            if (k > 0) {
                kLastDigit = k % 10;
                k = k / 10;
            }
            
            if (idx >= 0) {
                numDigit = num[idx];
                idx--;
            }
            
            // System.out.println("kDigit : " + kLastDigit);
            // System.out.println("numDigit : " + numDigit);
            // System.out.println("carry : " + carry);
            
            int sum = kLastDigit + numDigit + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            // System.out.println("carry- after : " + carry);
            // System.out.println("sum : " + sum);
            
            result.add(sum);
            // System.out.println("idx : " + idx);
        }
        
        if (carry > 0) {
            result.add(carry);
        }
        
        Collections.reverse(result);
        return result;
    }
}