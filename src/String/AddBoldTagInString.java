package String;

public class AddBoldTagInString {
	public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for(String d : dict) {
            for(int i = 0; i <= s.length()-d.length();i++) {
                if (s.substring(i,i+d.length()).equals(d)) {
                    for(int j = i; j < i+d.length();j++) {
                        bold[j] = true;
                    }
                }                
            }    
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bold.length;) {
            if (bold[i]) {
                sb.append("<b>");
                while(i < bold.length && bold[i]) {
                    sb.append(s.charAt(i++));
                }
                sb.append("</b>");                 
            } else {
                sb.append(s.charAt(i++));
            }            
        }
        return sb.toString();        
    }
}
