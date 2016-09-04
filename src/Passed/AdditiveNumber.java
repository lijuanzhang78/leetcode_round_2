package Passed;

public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
        int len = num.length();
        
        for(int i = 1; i <= (len-1)/2; i++) {
            if (num.charAt(0) == '0' && i >= 2) break;
            
            for(int j = i+1; len-j >= (j-i) && len-j >= i; j++) {
                if (num.charAt(i) == '0' && j-i>=2) break;
                Long num1 = Long.parseLong(num.substring(0,i));
                Long num2 = Long.parseLong(num.substring(i,j));
                
                String str = num.substring(j);
                if (isValid(num1, num2, str)) return true;            
            }
        }
        return false;
    }
    
    boolean isValid(Long num1, Long num2, String str) {
        if (str.equals("")) return true;
        long sum = num1 + num2;
        
        String strsum = ((Long)sum).toString();
        if (!str.startsWith(strsum)) return false;
        
        return isValid(num2, sum, str.substring(strsum.length()));
    }
}
