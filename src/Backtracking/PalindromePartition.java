package Backtracking;

// 纯backtracking
public class PalindromePartition {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        helper(s,res,new ArrayList<String>(),0);
        return res;
    }
    
    void helper(String s, List<List<String>> res, List<String> list, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            String str = s.substring(start,i+1);
            if (isPalindrome(str)) {
                list.add(str);
                helper(s,res,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
}
