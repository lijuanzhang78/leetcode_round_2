package Passed;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strings) {
            String transtr = shift(str);
            if (!map.containsKey(transtr)) {
                List<String> list = new ArrayList<>();
                map.put(transtr, list);
            }
            map.get(transtr).add(str);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    String shift(String str) {
        int n = str.length();
        char[] ch = new char[n];
        int diff = str.charAt(0) - 'a';
        for(int i = 0; i < n; i++) {
            ch[i] = str.charAt(i) - 'a' - diff >= 0? (char)(str.charAt(i) - diff) : (char)(str.charAt(i) - diff + 26 );
        }
        return String.valueOf(ch);
    }
}
