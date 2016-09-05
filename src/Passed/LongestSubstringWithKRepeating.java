package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class LongestSubstringWithKRepeating {
	public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) return 0;
        
        int max = Integer.MIN_VALUE;
        helper(max, s, k);
        return max;
    }
    
    private void helper(int max, String s, int k) {
        if (s.length() < k) return;
        
        TreeSet<Integer> brk = new TreeSet<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                List<Integer> list = new ArrayList<>();
                map.put(s.charAt(i), list);
            }
            map.get(s.charAt(i)).add(i);
        }
        
        for(Character ch : map.keySet()) {
            if (map.get(ch).size() < k) {
                for(Integer index : map.get(ch)) {
                    brk.add(index);
                }
            }
        }
        
        if (brk.size() == 0) {
            max = Math.max(max, s.length());
            return;
        }
        
        brk.add(s.length());
        int start = 0;
        for(Integer index : brk) {
            if (start < index) {
                String str = s.substring(start, index);
                helper(max,str,k);
                start = index+1;
            }
        }
    }
    
    public static void main(String[] args) {
    	int res = new LongestSubstringWithKRepeating().longestSubstring("aaabb", 3);	
    }

}
