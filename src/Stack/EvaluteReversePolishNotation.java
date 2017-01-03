package Stack;

public class EvaluteReversePolishNotation {
	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens) {
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stack.push(Integer.valueOf(s));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = 0;
                if (s.equals("+")) {
                    res = op1+op2;
                } else if (s.equals("-")) {
                    res = op1-op2;
                } else if (s.equals("*")) {
                    res = op1*op2;
                } else {
                    res = op1/op2;
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
}
