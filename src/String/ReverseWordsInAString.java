package String;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return new String();
        boolean inword = false;
        String news = "";
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (inword) {
                    news = temp.toString() + " " + news;
                    temp.setLength(0);
                    inword = false;
                }
            } else {
                temp.append(ch);
                if (!inword) inword = true;
            }
        }
        if (inword) news = temp.toString() + " " + news;
        return news.trim();
    }
}
