package String;

public class NumberOfSegmentInAString {
	public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean inSeg = false;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (inSeg) {
                    res++;
                    inSeg = false;
                }
            } else {
                if (!inSeg) inSeg = true;
            } 
        }
        return inSeg? ++res : res;
    }
}
