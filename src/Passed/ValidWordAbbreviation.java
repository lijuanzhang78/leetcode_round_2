package Passed;

public class ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
        if ((word == null || word.length() == 0) && (abbr == null || abbr.length() == 0)) return true;
        
        int num = 0;
        int i = 0, j = 0;
        for(i = 0, j = 0; i < abbr.length() && j < word.length();i++,j++) {
            while (i < abbr.length() && abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                if (abbr.charAt(i) == '0' && num == 0) return false;
                num = num*10 + abbr.charAt(i) - '0';
                i++;
            } 
            j += num;
            num = 0;
            if (i < abbr.length() && j < word.length()) {
                if (word.charAt(j) != abbr.charAt(i)) return false;
            } else {
                break;
            }
        }
        if (i == abbr.length() && j == word.length()) {
            return true;
        } else {
            return false;
        }
    }
	
	public static void main(String[] args) {
		String word = "abbreviation";
		String abbr = "a10n";
		boolean res = new ValidWordAbbreviation().validWordAbbreviation(word, abbr);	
	}

}
