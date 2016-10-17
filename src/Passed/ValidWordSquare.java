package Passed;

public class ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return true;
        
        int n = words.size();
        for(int i = 0; i < n; i++) {
            int j = 0;
            for(j = 0; j < words.get(i).length(); j++) {
                char ch = words.get(i).charAt(j);
                if (j >= n || i >= words.get(j).length() || words.get(j).charAt(i) != ch) {
                    return false;
                }
            }
            while(j < n) {
                if (i < words.get(j).length()) return false;
                j++;
            }    
        }
        return true;
    }
}
