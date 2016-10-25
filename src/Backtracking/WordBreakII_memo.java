package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII_memo {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<>();
        return helper(s, wordDict, map, 0);
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map,int start) {
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            return res;
        }
        if (map.containsKey(s.substring(start))) {
            return map.get(s.substring(start));
        }
        for(int i = start; i < s.length(); i++) {
            String prefix = s.substring(start,i+1);
            if (wordDict.contains(prefix)) {
                if (i == s.length()-1) res.add(prefix); // 这一步很重要，不要忘了加他自己
                List<String> temp = helper(s,wordDict,map,i+1);
                for(String str : temp) {
                    res.add(prefix + " " + str);
                }
            }
        }
        map.put(s.substring(start),res); // res 如果为空也要push进去，说明s.substring(start)不可分
        
        return res;
    }
	
    public static void main(String[] args) {
    	String s = "catsanddog";
    	Set<String> wordDict = new HashSet<>();
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");
    	List<String> res = new WordBreakII_memo().wordBreak(s,wordDict);
    }

}
