package Passed;

public class LetterCombinationOfAPhoneNumber {
Map<Character, String> map = new HashMap<Character,String>();
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0 || digits.contains("1")) {
            return new ArrayList<String>();
        }
        buildMap(map);
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(0,res,sb,digits);
        return res;
    }
    
    private void helper(int pos, List<String> res, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        char curr = digits.charAt(pos);
        String currstr = map.get(curr);
        
        for(int i = 0; i < currstr.length(); i++) {
            sb.append(currstr.charAt(i));
            helper(pos+1, res, sb, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    private void buildMap(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
