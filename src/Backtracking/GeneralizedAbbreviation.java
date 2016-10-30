package Backtracking;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        };
        
        helper(word,res,"",0,0);
        return res;
    }
    
    void helper(String word, List<String> res, String prev, int pos, int count) {
        if (pos == word.length()) {
            res.add(new String(prev+(count > 0? count : "")));
            return;
        }
        
        helper(word,res,prev+(count > 0? count : "")+word.charAt(pos),pos+1,0);
        helper(word,res,prev,pos+1,count+1);
    }
}
