package Passed;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('A');
        set.add('e'); set.add('E');
        set.add('i'); set.add('I');
        set.add('o'); set.add('O');
        set.add('u'); set.add('U');
        
        int i = 0, j = s.length()-1;
        char[] chs = s.toCharArray();
        
        while(i < j) {
            while(i < s.length() && !set.contains(chs[i])) i++;
            while(j >= 0 && !set.contains(chs[j])) j--;
            if (i >= j) break;
            
            if (i < s.length() && j >= 0) {
                char temp = chs[i];
                chs[i] = chs[j];
                chs[j] = temp;
                i++;j--;
            }
        }
        
        return new String(chs);
    }
	
	public static void main(String[] args) {
		String res = new ReverseVowelsOfString().reverseVowels("hello");	
	}
	
}
