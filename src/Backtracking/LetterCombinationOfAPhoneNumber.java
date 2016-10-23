package Backtracking;

public class LetterCombinationOfAPhoneNumber {
String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        helper(digits,sb,0,res);
        return res;
    }
    
    private void helper(String digits, StringBuilder sb, int pos, List<String> res) {
        if (pos == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        String curropt = letters[digits.charAt(pos)-'0'];
        for(int i = 0; i < curropt.length(); i++) {
            sb.append(curropt.charAt(i));
            helper(digits,sb,pos+1,res);
            sb.deleteCharAt(sb.length()-1); // 用法 deleteCharAt
        }
    }
}
