package TwoPointers;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        
        while(i < j) {
            while(i < j && !isValid(s.charAt(i))) i++;
            while(j > i && !isValid(s.charAt(j))) j--;
            if (i < s.length() && j >= 0) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;j--;
            }
        }
        return true;
    }
    private boolean isValid(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
