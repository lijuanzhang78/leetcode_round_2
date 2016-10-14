package Passed;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch)+1);
            }
        }
        
        int single = 0;
        for(Character ch : map.keySet()) {
            if (map.get(ch)%2 != 0) {
                single++;
            }
        }
        return single <= 1;
    }
}
