package String;

public class ReverseWordsInAStringIII {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return new String("");
        char[] charr = s.toCharArray();
        for(int i = 0; i < s.length();) {
            int j = i;
            while(j < s.length() && charr[j] != ' ') j++;
            reverse(charr, i, j-1);
            i = j+1;
        }
        
        return new String(charr);
    }
    
    void reverse(char[] charr, int i, int j) {
        while(i < j) {
            char temp = charr[i];
            charr[i] = charr[j];
            charr[j] = temp;
            i++;j--;
        }
    }
}
