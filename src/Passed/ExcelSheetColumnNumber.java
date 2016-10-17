package Passed;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = ch - 'A' + 1;
            res = res*26 + num;
        }
        return res;
    }
}
