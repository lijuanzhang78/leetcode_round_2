package Passed;

public class SimplifyPath {
	public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return new String();
        int i = 0;
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        if (path.charAt(path.length()-1) != '/') path += "/";
        while(i < path.length()) {
            if (path.charAt(i) == '/') {
                i++;
                if (sb.length() > 0) {
                    String str = sb.toString();
                    sb.setLength(0);
                    if (str.equals("..")) {
                        if (stack.size() > 0) {
                            stack.pop();
                        } 
                    } else if (str.equals(".")) {
                        continue;
                    } else {
                        stack.push(str);
                    }
                }
            } else {
                sb.append(path.charAt(i));
                i++;
            }
        }
        
        String res = "";
        while(stack.size() > 0) {
            res = "/"+ stack.pop() + res;
        }
        
        return res.equals("")? "/" : res;
    }
}
