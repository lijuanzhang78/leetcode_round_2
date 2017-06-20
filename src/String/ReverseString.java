package String;

public class ReverseString {
	public String reverseString(String s) {
        if (s == null || s.length() == 0) return new String();
        char[] charr = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while(low < high) {
            char temp = charr[low];
            charr[low] = charr[high];
            charr[high] = temp;
            low++; high--;
        }
        return new String(charr);
    }
}
