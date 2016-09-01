package Passed;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
        //if (s == null || s.length() == 0 || t == null || t.length() == 0) return 0;
        
        int[] counts = new int[26]; 
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts[ch - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            counts[ch - 'a']--;
        }
        
        for(int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                int res = 'a' + i;
                return (char)res;
            };
        }
        return 0;
    }

}
