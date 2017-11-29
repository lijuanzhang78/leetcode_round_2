package String;

public class LongestWordInDictionaryThroughDeleting {
	public String findLongestWord(String s, List<String> d) {
        if (s == null || s.length() == 0 || d == null || d.size() == 0) return "";
        String res = "";
        
        char[] arr = s.toCharArray();
        for(String w : d) {
            int i = 0;
            for(int j = 0; j < arr.length && i < w.length();) {
                if (arr[j] == w.charAt(i)) {
                    i++;
                    if (i == w.length()) {
                        if (w.length() >= res.length()) {
                            if (w.length() > res.length()) {
                                res = w;
                            } else {
                                res = w.compareTo(res) < 0? w : res;
                            }
                        }  
                    }
                }
                j++;   
            }    
        }
        return res;   
    }

}
