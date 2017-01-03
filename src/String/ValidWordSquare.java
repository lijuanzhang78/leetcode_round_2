package String;

public class ValidWordSquare {
	public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) return true;
        for(int i = 0; i < words.size(); i++) {
            String s = words.get(i);
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (j >= words.size()) return false;
                if (i >= words.get(j).length()) return false;
                char c2 = words.get(j).charAt(i);
                if (c != c2) return false;
            }
        }
        return true;
    }
}
