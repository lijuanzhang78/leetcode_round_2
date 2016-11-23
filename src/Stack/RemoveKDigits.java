package Stack;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if (num == null || num.length() < k) return "";
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if(stack.isEmpty()) {
                stack.push(ch);
            } else {
                while (!stack.isEmpty() && ch < stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                } 
                stack.push(ch);
            }
        }
        
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().toString();
        int i = 0;
        while(i < res.length() && res.charAt(i) == '0') i++;
        return res.substring(i).equals("")? "0":res.substring(i);
    }
	
	public static void main(String[] args) {
		String num = "10";
		int k = 2;
		String res = new RemoveKDigits().removeKdigits(num, k);		
	}
}
