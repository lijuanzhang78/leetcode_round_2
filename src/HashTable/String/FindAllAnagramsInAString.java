package HashTable.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        Map<Character,Integer> toMatch = new HashMap<>();
        int match = 0;
        for(int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (toMatch.containsKey(ch)) {
                toMatch.put(ch,toMatch.get(ch)+1);
            } else {
                toMatch.put(ch,1);
            }
        }
        
        for(int i = 0; i < s.length();i++) {
            char ch = s.charAt(i);
            if (toMatch.containsKey(ch)) {
                toMatch.put(ch, toMatch.get(ch)-1);
                if (toMatch.get(ch) >= 0) match++;
            }
            if (i >= p.length()) {
                char first = s.charAt(i-p.length());
                if (toMatch.containsKey(first)) {
                    toMatch.put(first,toMatch.get(first)+1);
                    if (toMatch.get(first) > 0) match--;
                }
            }
            if (match == p.length()) {
                res.add(i-p.length()+1);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = new FindAllAnagramsInAString().findAnagrams(s, p);		
	}
}
