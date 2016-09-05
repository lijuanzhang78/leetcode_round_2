package Passed;

public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) return new ArrayList<Integer>();
        return helper(input);
    }
    
    List<Integer> helper(String input) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while(i < input.length() && input.charAt(i) != '+' && input.charAt(i) != '-' && input.charAt(i) != '*' && input.charAt(i) != '/') i++;
        if (i == input.length()) {
            res.add(Integer.valueOf(input));
            return res;
        }
    
        for(i = 0; i < input.length(); i++) {
            char oper = input.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*' || oper == '/') {
                List<Integer> part1 = helper(input.substring(0,i));
                List<Integer> part2 = helper(input.substring(i+1));
                for(int num1: part1) {
                    for(int num2 : part2) {
                        if (oper == '+') res.add(num1+num2);
                        if (oper == '-') res.add(num1-num2);
                        if (oper == '*') res.add(num1*num2);
                        if (oper == '/') res.add(num1/num2);
                    }
                }
            }
        }
        return res;
    
}
