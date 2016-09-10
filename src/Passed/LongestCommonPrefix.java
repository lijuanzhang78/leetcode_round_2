package Passed;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return new String("");
        String str0 = strs[0];
        for(int i = 0; i < str0.length(); i++) {
            char ch = str0.charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if (strs[j].length() > 0) {
                    if (strs[j].indexOf(ch) != 0) return str0.substring(0,i);
                } else {
                    return str0.substring(0,i);
                }
                strs[j] = strs[j].substring(1);
            }
        }
        return new String(strs[0]);
    }
}
