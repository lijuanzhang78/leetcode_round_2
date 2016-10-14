package Passed;

public class SentenceScreenFiiting {
	public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0) return 0;
        
        int[] times = new int[sentence.length];
        int[] next = new int[sentence.length];
        
        for(int i = 0; i < sentence.length; i++) {
            int currlength = 0;
            int index = i;
            int time = 0;
            while(currlength+sentence[index].length() <= cols) {
                currlength += sentence[index].length()+1;
                index++;
                if (index == sentence.length) {
                    index = 0;
                    time++;
                }
            }
            times[i] = time;
            next[i] = index;
        }
        
        int res = 0;
        int nt = 0;
        for(int i = 0; i < rows; i++) {
            res += times[nt];
            nt = next[nt]; 
        }
        return res;
    }
}
