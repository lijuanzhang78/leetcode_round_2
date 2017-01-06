package Stack;

public class TerneryExpressionParser {
	public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Stack<Character> stack = new Stack<Character>();
        for(int i = expression.length() - 1; i >= 1;) {
            char c = expression.charAt(i);
            if (c == '?') {
                char c1 = stack.pop();
                stack.pop();
                char c2 = stack.pop();
                char tf = expression.charAt(i-1);
                stack.push(tf == 'T'? c1 : c2);
                i-=2;
            } else {
                stack.push(c);
                i--;
            }
            
        }
        return String.valueOf(stack.pop());
    }
}
