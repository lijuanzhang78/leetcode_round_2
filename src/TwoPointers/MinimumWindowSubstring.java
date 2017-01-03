package TwoPointers;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        
        int minstart = 0, start = 0;
        int res = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)-1);
                if (map.get(c) >= 0) count++;
                
                while(count == t.length()) {
                    int len = i - start + 1;
                    if (res > len) {
                        res = len;
                        minstart = start;
                    }
                    char front = s.charAt(start);
                    if (map.containsKey(front)) {
                        map.put(front,map.get(front)+1);
                        if (map.get(front) > 0) count--; 
                    }
                    start++;
                }
            }
        }
        return res == Integer.MAX_VALUE? "" : s.substring(minstart,minstart+res);
    }
}
