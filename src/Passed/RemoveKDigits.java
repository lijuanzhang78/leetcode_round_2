package Passed;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return new String();
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < num.length(); i++) {
            if (i == 0) {
                stack.push(num.charAt(0));
                continue;
            } else {
                while(!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.size() > num.length() - k) {
            stack.pop();
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0? new String("0") : sb.toString();
    }
}
