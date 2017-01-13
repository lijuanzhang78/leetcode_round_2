package Backtracking;

import java.util.HashMap;
import java.util.Map;

// substring(i) when i == s.length, it will return empty string
// startsWith

public class WordPatternII_2nd {
	public boolean wordPatternMatch(String pattern, String str) {
        if ((pattern == null || pattern.length() == 0) && (str == null || str.length() == 0)) return true;
        if ((pattern == null || pattern.length() == 0) || (str == null || str.length() == 0)) return false;
        Map<Character,String> map = new HashMap<Character,String>();
        if (dfs(pattern,0,str,map)) return true;
        return false;
    }
    
    boolean dfs(String pattern, int ip, String str, Map<Character,String> map) {
        if (ip == pattern.length() && str.equals("")) return true;
        if (ip == pattern.length() || str.equals("")) return false;
        char ch = pattern.charAt(ip);
        String toMatch = null;
        if (map.containsKey(ch)) {
            toMatch = map.get(ch);
            if (!str.startsWith(toMatch)) return false;
            return dfs(pattern,ip+1,str.substring(toMatch.length()),map);
        }
        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(0,i+1);
            if (map.containsValue(s)) continue;
            map.put(ch,s);
            if (dfs(pattern,ip+1,str.substring(i+1),map)) return true;
            map.remove(ch);
        }
        return false;
    }
    
    public static void main(String[] args) {
    	String pattern = "aba";
    	String str = "aaaa";
    	boolean res = new WordPatternII_2nd().wordPatternMatch(pattern, str);
    }
}
