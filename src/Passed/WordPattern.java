package Passed;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) return true;
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        
        Map<String, Character>map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])) {
                if (map.get(strs[i]) != pattern.charAt(i)) return false;
            } else {
                if (map.containsValue(pattern.charAt(i))) return false;
                map.put(strs[i], pattern.charAt(i));
            }
        }
        return true;    
    }
}
