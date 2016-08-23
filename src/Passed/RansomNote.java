package Passed;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null) return true;
        if (ransomNote != null && magazine == null) return false;
        
        int[] chars = new int[26];
        for(int i = 0; i < magazine.length();i++) {
            char ch = magazine.charAt(i);
            chars[ch - 'a']++;
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (chars[ch-'a'] == 0) return false;
            chars[ch-'a']--;
        }
        return true;
    }
}
