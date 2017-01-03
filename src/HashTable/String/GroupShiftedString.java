package HashTable.String;

// pay attention to some usage

public class GroupShiftedString {
	public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings) {
            convert(s,map);
        }
        List<List<String>> res = new ArrayList<>();
        for(String s : map.keySet()) {
            List<String> list = map.get(s);
            res.add(new ArrayList<String>(list));
        }
        return res;
    }
    
    void convert(String s, Map<String,List<String>> map) {
        char[] arr = s.toCharArray();
        int diff = arr[0] - 'a';
        arr[0] = 'a';
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i] - diff;
            if (temp < 'a') temp += 26; // not if (temp < 0), which is wrong
            arr[i] = (char)temp;
        }
        String news = new String(arr);
        if (!map.containsKey(news)) map.put(news, new ArrayList<String>());
        map.get(news).add(s);
    }
}
