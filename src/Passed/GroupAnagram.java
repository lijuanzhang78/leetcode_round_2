package Passed;

public class GroupAnagram {
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String sch = String.valueOf(chs);
            if (!map.containsKey(sch)) {
                map.put(sch, new ArrayList<String>());
            }
            map.get(sch).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
