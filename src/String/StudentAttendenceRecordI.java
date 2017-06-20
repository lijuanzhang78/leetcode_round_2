package String;

public class StudentAttendenceRecordI {
	public boolean checkRecord(String s) {
        if (s == null || s.length() == 0) return true;
        int numA = 0, numL = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                numA++;
                if (numA > 1) return false;
            } else if (ch == 'L') {
                numL++;
                if (numL > 2) {
                    if (s.charAt(i-1) == 'L' && s.charAt(i-2) == 'L') return false;
                }
            }
        }
        return true;
    }
}
