package String;

public class RepeatedStringPattern {
	public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0) return true;
        int len = str.length();
        for(int i = 1; i < len; i++) {
            if (checkRepeat(str,i)) return true;
        }
        return false;
    }
    
    boolean checkRepeat(String str, int unitlen) {
        String first = str.substring(0,unitlen);
        for(int i = 0; i < str.length(); i += unitlen) {
            int right = i+unitlen;
            // 这一步check很重要
            if (i+unitlen > str.length()) {
                right = str.length();
            }
            String s = str.substring(i,right);
            if (!first.equals(s)) return false;
        }
        return true;
    }	
}
