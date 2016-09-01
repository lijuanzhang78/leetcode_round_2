package Passed;

public class MiniParser {
	public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return new NestedInteger();
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        NestedInteger res = null;
        
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                NestedInteger curr = new NestedInteger();
                if (!stack.isEmpty()) stack.peek().add(curr);
                stack.push(curr);
                start = i+1;
            } else if (ch == ',' || ch == ']') {
                if (i > start) {
                    String str = s.substring(start, i);
                    stack.peek().add(new NestedInteger(Integer.parseInt(str)));
                }
                start = i+1;
                if (ch == ']') {
                    res = stack.pop();
                }
            }
        }
        return res;
    }
}
