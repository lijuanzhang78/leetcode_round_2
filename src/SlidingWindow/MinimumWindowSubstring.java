package SlidingWindow;

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
        
        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        int count = 0;
        int start = left;
        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) >= 0) count++;
                
                while(count == t.length()) {
                    if (right-left+1 < len) {
                        len = right-left+1;
                        start = left;
                    }
                    char c = s.charAt(left);
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c)+1);
                        if (map.get(c) > 0) count--;
                    }
                    left++;
                }
            }
        }
        return len == Integer.MAX_VALUE? "" : s.substring(start,start+len);
    }
}
