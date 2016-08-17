package Passed;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int res = 0;
        int i = 0, j = 0;
        for(i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for(j = i; j < n; j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            res = Math.max(res, j-i);
        }
        return res;
    }
}
