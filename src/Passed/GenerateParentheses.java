package Passed;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        if (n < 1) return new ArrayList<String>();
        
        int left = n, right = n;
        List<String> res = new ArrayList<String>();
        helper(res, "", left, right, 0, n);
        return res;
    }
    
    private void helper(List<String> res, String curr, int left, int right, int start, int n) {
        if (left == 0 && right == 0 && start == 2*n) {
            res.add(new String(curr));
            return;
        }
        
        if (left > 0) {
            if (isValid(curr+"(")) {
                helper(res, curr+"(", left-1, right, start+1, n);
            } 
        }
        
        if (right > 0) {
            if (isValid(curr+")")) {
                helper(res, curr+")", left, right-1, start+1, n);
            }
        }
    }
    
    boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.size() == 0) return false;
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        if (stack.size() == 0) return true;
        while(stack.size() > 0) {
            if (stack.pop() == ')') return false;
        }
        
        return true;
    }
}
