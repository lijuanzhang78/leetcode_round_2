package HashTable.String;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String base = new String(arr);
            if (!map.containsKey(base)) {
                map.put(base, new ArrayList<String>());
            }
            map.get(base).add(strs[i]);
        }
        return new ArrayList(map.values());
    }
}
