package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length()==0 || p.length() > s.length()) return res;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (!map.containsKey(ch)) map.put(ch,0); 
            map.put(ch,map.get(ch)+1);
        }
        
        int left = 0, right = 0;
        int match = 0;
        for(right = 0; right < p.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch,map.get(ch)-1);
                if (map.get(ch) >= 0) match++;
            }
        }
        if (match == p.length()) res.add(left);
        
        while(right < s.length()) {
            char cr = s.charAt(right);
            if (map.containsKey(cr)) {
                map.put(cr,map.get(cr)-1);
                if (map.get(cr) >= 0) match++;
            }
            right++;
            char cl = s.charAt(left);
            left++;
            if (map.containsKey(cl)) {
                map.put(cl,map.get(cl)+1);
                if (map.get(cl) > 0) match--;
            }
            if (match == p.length()) res.add(left);
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = new FindAllAnagramsInAString().findAnagrams(s, p);		
	}
}
