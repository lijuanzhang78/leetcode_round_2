package Passed;

import java.util.Stack;

public class BasicCalculatorII {
	public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<String> stack = new Stack<String>();
    
        int i = 0;
        while(i < s.length()) {
            while(i < s.length() && s.charAt(i) == ' ') i++;
            int start = i++;
            while(i < s.length() && s.charAt(i) != ' ' && s.charAt(i) != '+' && s.charAt(i) != '-' &&
                  s.charAt(i) != '*' && s.charAt(i) != '/') i++;
            String num = s.substring(start,i);
            if (stack.size() > 0 && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                String oper = stack.pop();
                String prev = stack.pop();
                int res = 0;
                if (oper.equals("*")) {
                    res = Integer.parseInt(num) * Integer.parseInt(prev);
                } else {
                    res = Integer.parseInt(prev) / Integer.parseInt(num);
                }
                stack.push(String.valueOf(res));
            } else {
                stack.push(num);
            }
            
            while(i < s.length() && s.charAt(i) == ' ') i++;
            if (i < s.length() && (s.charAt(i) == '+'||s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')) {
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            } 
        }
        
        int sum = 0;
        while(stack.size() > 0) {
            Integer num = Integer.parseInt(stack.pop());
            if (stack.size() > 0) {
                String oper = stack.pop();
                if (oper.equals("+")) {
                    sum = sum + num;
                } else {
                    sum = sum-num;
                }
            } else {
                sum += num;
            }
        }
        
        return sum;
    }	
}
