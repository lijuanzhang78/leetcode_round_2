package Passed;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch)+1);
            }
            
        }
        
        int res = 0;
        boolean flag = false;
        for(Character ch : map.keySet()) {
            res += map.get(ch)/2;
            if (map.get(ch) % 2 != 0) {
                flag = true;
            }
               
        }
        return flag == false? res*2 : res*2+1;
    }
}
