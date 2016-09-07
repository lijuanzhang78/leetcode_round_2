package Passed;

public class ValidParentheses {
	public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']' || ch == '}' || ch == ')') {
                if (stack.size() == 0) return false;
                if (stack.peek() == '[' && ch == ']' ||
                    stack.peek() == '{' && ch == '}' ||
                    stack.peek() == '(' && ch == ')') {
                        stack.pop();
                } else {
                    return false;
                } 
            }
        }
        return stack.size() == 0? true: false;
    }
}
