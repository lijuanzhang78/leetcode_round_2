package Passed;

public class AddBinary {
	public String addBinary(String a, String b) {
        if (a == null && b == null) return new String();
        if (a == null) return b;
        if (b == null) return a;
        
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int curr = carry;
            if (i >= 0) {
                curr += a.charAt(i)-'0';
                i--;
            }
            if (j >= 0) {
                curr += b.charAt(j)-'0';
                j--;
            }
            carry = curr/2;
            curr %= 2;
            sb.append(curr);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
