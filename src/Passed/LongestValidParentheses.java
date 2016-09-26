package Passed;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        int[] longest = new int[length];
        
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                longest[i] = 0;
            } else {
                if(s.charAt(i-1) == '(') {
                    longest[i] = i-2>=0? longest[i-2]+2 : 2;
                } else {
                    if (i-longest[i-1]-1 >= 0) {
                        if (s.charAt(i-longest[i-1]-1) == '(') {
                            longest[i] = i-longest[i-1]-2>=0? longest[i-longest[i-1]-2]+longest[i-1]+2 : longest[i-1]+2;
                        }
                    }
                }
            }
            max = Math.max(max, longest[i]);
        }
        return max == Integer.MIN_VALUE? 0 : max;
    }
}
