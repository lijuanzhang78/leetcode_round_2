package Backtracking;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        helper(res,"",0,0,n);
        return res;       
    }
    
    void helper(List<String> res, String curr, int left, int right, int max) {
        if (curr.length() == 2*max) {
            res.add(curr);
            return;
        }
        
        if (left < max) {
            helper(res,curr+"(",left+1,right,max);
        }
        if (left > right) {
            helper(res,curr+")",left,right+1,max);
        }        
    }   
}
