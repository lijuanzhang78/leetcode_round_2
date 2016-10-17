package Passed;

public class EncodeAndDecodeString {
	 // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        } 
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length();) {
            int start = i;
            while(i < s.length() && s.charAt(i) != '#') {
                i++;
            }
            int len = Integer.parseInt(s.substring(start,i));
            i++;
            res.add(s.substring(i,i+len));
            i += len;
        }
        return res;
    }
}
