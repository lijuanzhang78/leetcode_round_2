package Backtracking;

public class GeneralizedAbbreviation_2nd {
	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) {
            res.add("");
            return res;
        }
        StringBuilder sb = new StringBuilder();
        
        dfs(word,0,0,sb,res);
        return res;
    }
    
    void dfs(String word, int pos, int count, StringBuilder sb, List<String> res) {
        if (pos == word.length()) {
            if (count > 0) {
                sb.append(count);
            }
            res.add(sb.toString());
            return;
        }
        
        // keep
        int len = sb.length();
        if (count > 0) {
            sb.append(count);
        }
        sb.append(word.charAt(pos));
        dfs(word,pos+1,0,sb,res);
        sb.setLength(len);
        
        // omit
        dfs(word,pos+1,count+1,sb,res);
    }
}
