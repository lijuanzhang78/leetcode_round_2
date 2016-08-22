package Passed;

public class PalindromePairs {
	 public List<List<Integer>> palindromePairs(String[] words) {
	        List<List<Integer>> res = new ArrayList<>();
	        if (words == null || words.length == 0) return res;
	        Map<String, Integer> map = new HashMap<>();
	        for(int i = 0; i < words.length; i++) {
	            map.put(words[i], i);
	        }
	        
	        if(map.containsKey("")) {
	            int bindex = map.get(""); 
	            for(int i = 0; i < words.length; i++) {
	                if (isPalindrome(words[i])) {
	                    if (i == bindex) continue;
	                    res.add(Arrays.asList(i, bindex));
	                    res.add(Arrays.asList(bindex, i));
	                }
	            }
	        }
	        
	        for(int i = 0; i < words.length; i++) {
	            String rev = reverseString(words[i]);
	            if (map.containsKey(rev)) {
	                int revindex = map.get(rev);
	                if (i == revindex) continue;
	                res.add(Arrays.asList(i, revindex));
	            }
	        }
	        
	        for(int i = 0; i < words.length; i++) {
	            for(int cut = 1; cut < words[i].length(); cut++) {
	                if (isPalindrome(words[i].substring(0, cut))) {
	                    String revs = reverseString(words[i].substring(cut));
	                    if (map.containsKey(revs)) {
	                        int revindex = map.get(revs);
	                        if (i == revindex) continue;
	                        res.add(Arrays.asList(revindex, i));
	                    }
	                }
	                if (isPalindrome(words[i].substring(cut))) {
	                    String revs = reverseString(words[i].substring(0,cut));
	                    if (map.containsKey(revs)) {
	                        int revindex = map.get(revs);
	                        if (i == revindex) continue;
	                        res.add(Arrays.asList(i, revindex));
	                    }
	                }
	            }
	        }
	        return res;
	    }

	    boolean isPalindrome(String s) {
	        int i = 0, j = s.length() - 1;
	        while(i < j) {
	            if (s.charAt(i) != s.charAt(j)) return false;
	            i++;
	            j--;
	        }
	        return true;
	    }
	    
	    String reverseString(String s) {
	        StringBuilder sb= new StringBuilder(s);
	        return sb.reverse().toString();
	    }

}
