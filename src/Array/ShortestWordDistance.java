package Array;

public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        for(int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (idx2 == -1) {
                    idx1 = i;
                } else {
                    idx1 = i; // need to be out outside of if loop
                    if (res > Math.abs(idx2 - i)) {
                        res = Math.abs(idx2-i);
                    }
                } 
            } else if (words[i].equals(word2)) {
                if (idx1 == -1) {
                    idx2 = i;
                } else {
                    idx2 = i;
                    if (res > Math.abs(idx1 - i)) {
                        res = Math.abs(idx1-i);
                    }
                } 
            }
        }
        return res;
    }
}
