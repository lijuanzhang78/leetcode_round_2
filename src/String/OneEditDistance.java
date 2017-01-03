package String;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() == t.length()) return isOneModify(s,t);
        if (s.length() > t.length()) return isOneDel(s,t);
        return isOneDel(t,s);
    }
    
    boolean isOneModify(String s, String t) {
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) return s.substring(i+1).equals(t.substring(i+1));
        }
        return false;
    }
    
    boolean isOneDel(String s, String t) {
        for(int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) return s.substring(i+1).equals(t.substring(i));
        }
        return true;
    }
}
