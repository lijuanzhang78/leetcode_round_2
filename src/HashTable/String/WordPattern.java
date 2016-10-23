package HashTable.String;

// 一一对应，需要一个hashset和一个hashmap

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 ||
            str == null || str.length() == 0) return false;
        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i])) return false;
            } else {
                if (set.contains(strs[i])) return false;
                map.put(ch,strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}
