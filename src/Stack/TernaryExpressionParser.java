package Stack;

public class TernaryExpressionParser {
	public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = expression.length()-1; i>=0;i--) {
            char ch = expression.charAt(i);
            if (ch !=  '?') {
                stack.push(ch);
            } else {
                char left = stack.pop();
                stack.pop();
                char right = stack.pop();
                if (expression.charAt(--i) == 'T') {
                    stack.push(left);
                } else {
                    stack.push(right);
                }
            }
        }
        return String.valueOf(stack.pop());
    }
}
