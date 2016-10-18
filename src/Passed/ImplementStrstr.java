package Passed;

public class ImplementStrstr {
	public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        int i = 0;
        for(i = 0; i <= haystack.length()-needle.length(); i++) {
            boolean found = true;
            for(int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		String haystack = "";
		String needle = "a";
		
		int res = new ImplementStrstr().strStr(haystack, needle);		
	}
}
