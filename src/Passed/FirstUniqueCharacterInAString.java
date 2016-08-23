package Passed;

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] chs = new int[26];
        
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            chs[ch-'a']++;
        }
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (chs[ch-'a'] == 1) return i;
        }
        return -1;
    }
}
