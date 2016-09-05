package Passed;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
	int max = Integer.MIN_VALUE;
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return 0;
        
        helper(s, k);
        return max == Integer.MIN_VALUE? 0 : max;
    }
    
    private void helper(String s, int k) {
        if (s.length() < k) return;
        
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map[ch-'a']++;
        }
        int smallest = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < map.length; i++) {
            if (map[i] > 0 && map[i] < smallest) {
                smallest = map[i];
                index = i;
            }
        }
        if (smallest >= k) {
            max = Math.max(max, s.length());
            return;
        }
        
        String[] strs = s.split(Character.toString((char)('a'+index)));
        for(String str : strs) {
            helper(str, k);
        }
    }
}
