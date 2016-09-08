package Passed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) return 0;
        int i = 0;
        int len = input.length();
        List<Stack<Integer>> list = new ArrayList<Stack<Integer>>();
        int level = 0, max = Integer.MIN_VALUE;
        while(i < input.length()) {
            String s = "";
            while (i < len && input.charAt(i) != '\n') {
                s += String.valueOf(input.charAt(i));
                i++;
            }
            if (s.contains(".")) {
                int res = 0;
                for(int j = 0; j < level; j++) {
                    res += list.get(j).peek() + 1;
                }
                max = Math.max(max, res+s.length());
            } else {
                if (list.size() == level) {
                    Stack<Integer> stack = new Stack<Integer>();
                    stack.push(s.length());
                    list.add(stack);
                } else {
                    list.get(level).push(s.length());
                }
            }
            
            i++;
            level = 0;
            while(i < len && input.charAt(i) == '\t') {
                i++;
                level++;
            }
        }
        return max == Integer.MIN_VALUE? 0: max;
    }
	
	public static void main(String[] args) {
		int len = new LongestAbsoluteFilePath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");	
	}
}
