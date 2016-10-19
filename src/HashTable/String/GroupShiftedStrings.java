package HashTable.String;

public class GroupShiftedStrings {
	 public List<List<String>> groupStrings(String[] strings) {
	        Map<String, List<String>> map = new HashMap<>();
	        for(String s : strings) {
	            String base = getBaseString(s);
	            if (!map.containsKey(base)) {
	                map.put(base, new ArrayList<String>());
	            }
	            map.get(base).add(s);
	        }
	        return new ArrayList(map.values()); // 注意用法，直接调用构造函数
	    }
	    
	    private String getBaseString(String s) {
	        char[] arr = s.toCharArray();
	        char[] barr = new char[arr.length];
	        int diff = arr[0] - 'a';
	        barr[0] = 'a';
	        
	        for(int i = 1; i < arr.length; i++) {
	            int curr = arr[i] - diff;
	            if (curr < 'a') curr += 26;
	            barr[i] = (char)curr;
	        }
	        return new String(barr);
	    }
}
