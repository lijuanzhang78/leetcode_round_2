package String;

public class RepeatedSubstringPattern_2 {
	public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return true;
        int len = s.length();
        for(int i = len/2; i >= 1; i--) {
            if (len%i == 0) {
                String unit = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < len/i; j++) {
                     sb.append(unit);
                }
                if (sb.toString().equals(s)) return true;                
            }
        }
        return false;
    }
}
