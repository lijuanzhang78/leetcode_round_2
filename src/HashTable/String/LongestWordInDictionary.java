package HashTable.String;

public class LongestWordInDictionary {
	public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";
        Set<String> set = new HashSet<>();
        for(String s : words) set.add(s);
        
        int max = Integer.MIN_VALUE;
        String ans = "";
        for(String s: words) {
            if (s.length() < ans.length()) continue;
            int i = 1;
            for(i = 1; i < s.length(); i++) {
                String sub = s.substring(0,i);
                if (!set.contains(sub)) {
                    break;
                }
            }
            if (i == s.length() && (s.length() > ans.length() || (s.length() == ans.length() && s.compareTo(ans) < 0))) {
                ans = s;
            }
        }
        return ans;        
    }

}
