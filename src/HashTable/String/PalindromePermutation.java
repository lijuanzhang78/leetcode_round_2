package HashTable.String;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        
        boolean single = false;
        for(char c : map.keySet()) {
            int num = map.get(c);
            if (num % 2 > 0) {
                if (single) return false;
                single = true;
            }
        }
        return true;
    }
}
