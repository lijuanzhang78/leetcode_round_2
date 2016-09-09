package Passed;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<List<String>>();
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(res, temp, 0, s);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> temp, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        } 
        
        for(int j = start+1; j <= s.length(); j++) {
            String str = s.substring(start,j);
            if (isValid(str)) {
                temp.add(str);
                helper(res, temp, j, s);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    boolean isValid(String s) {
        int i = 0, j = s.length()-1;
        while(i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
         }
        return true;
    }
}
