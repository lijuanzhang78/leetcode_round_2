package Passed;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return new String("");
        
        int[] product = new int[num1.length() + num2.length() - 1];
        
        for(int i = 0; i < num1.length(); i++) {
            for(int j = 0; j < num2.length(); j++) {
                int d1 = num1.charAt(num1.length()-1-i) - '0';
                int d2 = num2.charAt(num2.length()-1-j) - '0';
                product[i+j] += d1*d2;
            }
        }
                
        List<Integer> list = new ArrayList<>();
        for(int num : product) {
            list.add(num);
        }
        
        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int j = i;
            while(num > 0) {
                if (j < list.size()) {
                    if (j > i) {
                      list.set(j, num%10+list.get(j));
                    }
                    if (i == j) list.set(j, num%10);
                } else {
                    list.add(num%10);
                }
                num/=10;
                j++;
            }
        }
            
        String res = "";
        for(int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 0 && res == "") continue;
            res += list.get(i);
        }
        return res == ""? "0" : res;   
    }    	
}
