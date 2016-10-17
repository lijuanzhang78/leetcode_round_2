package Passed;

public class CountAndSay {
	public String countAndSay(int n) {
        if (n == 0) return "";
        int index = 1;
        String curr = "1";
        while(index < n) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < curr.length();) {
                char ch = curr.charAt(i++);
                int count = 1;
                while(i < curr.length() && curr.charAt(i) == ch) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(ch);
            }
            curr = sb.toString();
            index++;
        }
        return curr;    
    }
}
