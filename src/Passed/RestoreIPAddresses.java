package Passed;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        dfs(s, 0, "", res);
        return res;
    }
    
    void dfs(String s, int start, String prev, List<String> res) {
        if (start == 3 && s.length() >= 0 && s.length() < 4) {
            if (isValid(s)) {
                prev = prev+s;
                res.add(prev);
            }
        }
        
        for(int i = 0; i < 3 && i < s.length(); i ++) {
            String str = s.substring(0, i+1);
            if (isValid(str) && i+1 < s.length()) {
                dfs(s.substring(i+1), start+1, prev+str+".", res);
            }
        }    
    }
    
    boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        if (num > 0 && num <= 255) return true;
        return false;
    }
}
