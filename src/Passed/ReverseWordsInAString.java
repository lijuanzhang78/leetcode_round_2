package Passed;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return new String();
        
        String[] strs = s.split("\\s+");
        String res = "";
        for(int i = strs.length - 1; i >= 0; i--) {
            res += strs[i] + " ";
        }
        res = res.trim();
        return res;
    }
}
