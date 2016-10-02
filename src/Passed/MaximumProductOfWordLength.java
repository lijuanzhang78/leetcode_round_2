package Passed;

public class MaximumProductOfWordLength {
	public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int[] values = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            for(int j = 0; j < w.length(); j++) {
                values[i] |= 1<<(w.charAt(j)-'a');
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if ((values[i] & values[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max == Integer.MIN_VALUE? 0 : max;
    }
}
