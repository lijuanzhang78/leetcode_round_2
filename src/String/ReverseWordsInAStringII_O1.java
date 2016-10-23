package String;

// 先reverse整个string，再reverse单个word
public class ReverseWordsInAStringII_O1 {
	public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;
        reverse(s,0,s.length-1);
        int l = 0;
        for(int r = 0; r < s.length;) {
            while(r < s.length && s[r] != ' ') r++;
            reverse(s,l,r-1);
            r++;
            l = r;
        }
        return;
    }
    
    void reverse(char[] s, int i, int j) {
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;j--;
        }
    }
}
