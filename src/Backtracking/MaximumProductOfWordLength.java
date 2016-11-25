package Backtracking;

public class MaximumProductOfWordLength {
	public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int[] values = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                values[i] |= 1 << words[i].charAt(j)-'a';    
            }
        }
        int maxlen = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if ((values[i] & values[j]) == 0 && maxlen < words[i].length()*words[j].length()) {
                    maxlen = words[i].length()*words[j].length();
                }
            }
        }
        return maxlen;
    }
}
