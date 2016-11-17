package SlidingWindow;

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        int count = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if(!map.containsKey(ch)) {
                map.put(ch,0);
            }
            map.put(ch,map.get(ch)+1);
            if (map.get(ch) > count) count = map.get(ch);
            
            while(right-left+1-count > k) {
                char chleft = s.charAt(left);
                map.put(chleft, map.get(chleft)-1);
                if (map.get(ch) == 0) map.remove(ch);
                count = 0;
                for(Character c : map.keySet()) {
                    count = Math.max(map.get(c), count);
                }
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
