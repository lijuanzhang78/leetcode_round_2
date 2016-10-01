package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Map<String, Integer> map = new HashMap<>();
        int strLen = s.length();
        int wordLen = words[0].length();
        
        for(String w : words) {
            if (!map.containsKey(w)) {
                map.put(w,1);
            } else {
                map.put(w, map.get(w)+1);
            }
        }
        
        for(int i = 0; i < wordLen; i++) {
            int count = 0, left = i;
            Map<String, Integer> currMap = new HashMap<>();
            for(int j = i; j <= strLen - wordLen; j += wordLen) {
                String curStr = s.substring(j, j+wordLen);
                if (map.containsKey(curStr)) {
                    if (currMap.containsKey(curStr)) {
                        currMap.put(curStr, currMap.get(curStr)+1);
                    } else {
                        currMap.put(curStr, 1);
                    }
                    if (currMap.get(curStr) <= map.get(curStr)) {
                        count++;
                    } else {
                        while(true) {
                            String tmp = s.substring(left, left+wordLen);
                            currMap.put(tmp, currMap.get(tmp)-1);
                            left = left+wordLen;
                            if (tmp.equals(curStr)) {
                                break;
                            } else {
                                count--;
                            }
                        }
                    }
                    if (count == words.length) {
                        res.add(left);
                        String tmp = s.substring(left, left+wordLen);
                        currMap.put(tmp, currMap.get(tmp)-1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    currMap.clear();
                    left = j+wordLen;
                    count = 0;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] words = {"word","good","best","good"};
		String s = "wordgoodgoodgoodbestword";
		List<Integer> res = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);	
	}

}
