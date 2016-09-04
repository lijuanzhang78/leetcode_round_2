package Passed;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;

        }
        if (carry != 0) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            for(int i = 1; i < res.length; i++) {
                res[i] = digits[i-1];
            }
            return res;
        } else {
            return digits;
        }
    }
}
