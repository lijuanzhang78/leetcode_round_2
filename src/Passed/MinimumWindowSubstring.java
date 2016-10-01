package Passed;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch)+1);
            }
        }
        
        int start = 0, minstart = 0;
        int res = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) count++;
                
                while(count == t.length()) {
                    if (i-start+1 < res) {
                        res = i-start+1;
                        minstart = start;
                    }
                    if (map.containsKey(s.charAt(start))) {
                        map.put(s.charAt(start), map.get(s.charAt(start))+1);
                        if (map.get(s.charAt(start)) > 0) count--;
                    }
                    start++;
                }
            }
        }
        return res == Integer.MAX_VALUE? "" : s.substring(minstart, minstart+res);
    }
}
