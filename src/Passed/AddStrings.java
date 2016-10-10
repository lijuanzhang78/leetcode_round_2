package Passed;

public class AddStrings {
	public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return (num2 == null || num2.length()==0)? "" : num2;
        if (num2 == null || num2.length() == 0) return (num1 == null || num1.length()==0)? "" : num1;
        
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            if (i >=0 && j >= 0) {
                int num = (num1.charAt(i)-'0') + (num2.charAt(j)-'0') + carry;
                sb.append(num%10);
                carry = num/10;
                i--;j--;
            } else if (i >= 0) {
                int num = num1.charAt(i)-'0' + carry;
                sb.append(num%10);
                carry = num/10;
                i--;
            } else if (j >= 0) {
                int num = num2.charAt(j)-'0' + carry;
                sb.append(num%10);
                carry = num/10;
                j--;
            }
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
