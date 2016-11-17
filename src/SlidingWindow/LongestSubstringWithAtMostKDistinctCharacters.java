package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0)  return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                map.put(ch,0);
            }
            map.put(ch,map.get(ch)+1);
            
            while(map.size() > k) {
            	// left++; 之前错在这里！！！
                char leftch = s.charAt(left);
                map.put(leftch, map.get(leftch)-1);
                if (map.get(leftch) == 0) {
                    map.remove(leftch);
                }
                left++; 
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
	
	public static void main(String[] args) {
		String s = "aba";
		int k = 1;
		int res = new LongestSubstringWithAtMostKDistinctCharacters().lengthOfLongestSubstringKDistinct(s, k);	
	}
}
