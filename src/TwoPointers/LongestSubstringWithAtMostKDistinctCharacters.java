package TwoPointers;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        int res = Integer.MIN_VALUE;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
                res = Math.max(res,i-start+1);
            } else {
                map.put(c,1);
                while(map.size() > k) {
                    char front = s.charAt(start);
                    if (map.containsKey(front)) {
                        map.put(front,map.get(front)-1);
                        if (map.get(front) == 0) map.remove(front);
                        start++;
                    }
                }
                res = Math.max(res,i-start+1);
            }
        }
        return res == Integer.MIN_VALUE? 0 : res;
    }
}
