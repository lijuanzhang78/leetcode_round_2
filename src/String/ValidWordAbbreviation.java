package String;

public class ValidWordAbbreviation {
	 public boolean validWordAbbreviation(String word, String abbr) {
	        if (word == null || word.length() == 0 || abbr == null || abbr.length()==0) return true;
	        int num = 0, i = 0, j = 0;
	        for(i = 0,j = 0; i < word.length() && j < abbr.length();) {
	            char ch1 = word.charAt(i);
	            char ch2 = abbr.charAt(j);
	            if (ch2 <= '0' || ch2 > '9') {
	                if (ch1 == ch2) {
	                    i++;j++;
	                } else {
	                    return false;
	                }
	            } else {
	                while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
	                    num = num*10 + abbr.charAt(j)-'0';
	                    j++;
	                }
	                i += num;
	                num = 0;
	            }
	        }
	        if (i != word.length() || j != abbr.length()) return false;
	        return true;
	    }
	 
	public static void main(String[] args) {
		String s1 = "internationalization";
		String s2 = "i12iz4n";
		boolean res = new ValidWordAbbreviation().validWordAbbreviation(s1, s2);	
	}
}
