package HashTable.String;

// 第一步check是多余

public class WordPattern_2nd {
	public boolean wordPattern(String pattern, String str) {
        //if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) return true;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!strs[i].equals(map.get(ch))) return false;
            } else {
                if (set.contains(strs[i])) return false;
                set.add(strs[i]);
                map.put(ch,strs[i]);
            }
        }
        return true;
    }
}
