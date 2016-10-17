package Passed;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return true;
        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        
        int i = 0, j = num.length() - 1;
        while(i <= j) {
            if (i == j) {
                char mid = num.charAt(i);
                if (mid == '0' || mid == '1' || mid == '8') {
                    return true;
                } else {
                    return false;
                }
            } else {
                char left = num.charAt(i);
                char right = num.charAt(j);
                if (!map.containsKey(left) || map.get(left) != right) return false;
                i++;j--;
            }
        }
        return true;
    }
}
