package Stack;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int sign = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int num = c-'0'; i++;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num*10 + s.charAt(i)-'0';
                    i++;
                }
                if (stack.size() > 0) {
                    res += sign * stack.peek() * num;
                } else {
                    res += sign * num;
                }
                num = 0;
               
            } else if (c == '+') {
                sign = 1; i++;
            } else if (c == '-') {
                sign = -1; i++;
            } else if (c == '(') {
                if (stack.size() > 0) {
                    stack.push(sign*stack.peek());
                } else {
                    stack.push(sign);
                }
                i++; sign = 1;
            } else if (c == ')') {
                stack.pop();
                i++;
            } else {
                i++;
            }
        }
        
        return res;
    }

	public static void main(String[] args) {
		int res = new BasicCalculator().calculate("2147483647");
	}
}
