package Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
        if ((pattern == null || pattern.length() == 0) &&
            (str == null || str.length() == 0)) return true;
        if ((pattern == null || pattern.length() == 0) ||
            (str == null || str.length() == 0)) return false;
            
            Map<Character, String> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            return helper(pattern,str,0,0,map,set);
    }
    
    boolean helper(String pattern, String str, int posp, int poss, Map<Character,String> map, Set<String> set) {
        if (posp == pattern.length() && poss == str.length()) return true;
        if (posp == pattern.length() || poss == str.length()) return false;
        
            char ch = pattern.charAt(posp);
            
            for(int j = poss; j < str.length(); j++) {
                String s = str.substring(poss, j+1);
                if (map.containsKey(ch)) {
                    if (!map.get(ch).equals(s)) {
                        continue;
                    } else {
  // 在s能match的时候要继续推进下一步
                        return helper(pattern,str,posp+1,j+1,map,set);
                    }
                } else {
                    if (set.contains(s)) continue;
                    map.put(ch,s);
                    set.add(s);
                    if (helper(pattern,str,posp+1,j+1,map,set)) {
                        return true;
                    } else {
                        map.remove(ch);
                        set.remove(s);
                    }
                }
            }
  // 最后一步需要return false
            return false;
    }
	
    public static void main(String[] args) {
    	String pattern = "abab";
    	String str = "redblueredblue";
    	boolean res = new WordPatternII().wordPatternMatch(pattern, str);
   	
    }

}
