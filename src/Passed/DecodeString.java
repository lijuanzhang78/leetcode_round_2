package Passed;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {
        if (s == null || s.length() == 0) return new String("");
        Stack<String> stack = new Stack<String>();
        int i = 0; 
        while(i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int num = ch - '0'; i++;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num*10 + ch - '0';
                    i++;
                }
                stack.push(String.valueOf(num));
            } else if (ch == '[') {
                stack.push("["); i++;
            } else if (ch >= 'a' && ch <= 'z') {
                String ss = String.valueOf(ch); i++;
                while(i < s.length() && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    ss += String.valueOf(s.charAt(i));
                    i++;
                }
                stack.push(ss);
            } else if (ch == ']') {
                String str = "";
                while(!stack.peek().equals("[")) {
                    str = stack.pop() + str;
                }
                stack.pop();
                String ss = "";
                Integer k = Integer.parseInt(stack.pop());
                for(int j = 0; j < k; j++) {
                    ss += str;
                }
                stack.push(ss);
                i++;
            }
        }
        
        String res = "";
        while(stack.size() > 0) {
            res = stack.pop() + res;
        }
        return res;
    }
	
	public static void main(String[] args) {
		String res = new DecodeString().decodeString("100[leetcode]");	
	}

}
