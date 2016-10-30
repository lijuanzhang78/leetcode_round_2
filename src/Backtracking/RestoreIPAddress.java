package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) return res;
        
        helper(res,"",s,0,4);
        return res;
    }
    
    void helper(List<String> res, String prev, String s, int start, int level) {
        if (level == 0 && start == s.length()) {
            res.add(new String(prev.substring(1)));
            return;
        }
        if (level == 0 && start != s.length()) return;
        if (level != 0 && start >= s.length()) return;
       
        for(int i = start; i < start+3; i++) {
            if (i+1 <= s.length() && isValid(s.substring(start,i+1))) {
                helper(res,prev+"."+s.substring(start,i+1), s, i+1,level-1);
            }
        }
    }
    
    boolean isValid(String s) {
        if (s.charAt(0) == '0') return s.equals("0");
        int num = Integer.parseInt(s);
        if (num > 0 && num <= 255) return true;
        return false;
    }
	
    public static void main(String[] args) {
    	String s = "0000";
    	List<String> res = new RestoreIPAddress().restoreIpAddresses(s);   	
    }
}
