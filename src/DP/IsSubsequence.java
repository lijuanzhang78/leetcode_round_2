package DP;

public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
        if (s == null && s.length() == 0 && t == null && t.length() == 0) return true;
        if (s == null || s.length() == 0 ) return true;
        if (t == null || t.length() == 0) return false;
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch,new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        
        int lastIdx = -1;
        for(int i = 0; i < s.length(); i++) {
            boolean found = false;
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) return false;
            List<Integer> list = map.get(ch);
            for(int j = 0; j < list.size(); j++) {
                if (list.get(j) > lastIdx) {
                    found = true;
                    lastIdx = list.get(j);
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
