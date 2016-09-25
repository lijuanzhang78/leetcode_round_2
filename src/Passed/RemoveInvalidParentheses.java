package Passed;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        Set<String> set = new HashSet<>();
        int rl = 0, rr = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rl++;
            }
            if (s.charAt(i) == ')') {
                if (rl > 0) {
                    rl--;
                } else {
                    rr++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        dfs(s, rl, rr, 0, 0, set, sb);
        return new ArrayList<String>(set);
    }
    
    void dfs(String s, int rl, int rr, int open, int pos, Set<String> set, StringBuilder sb) {
        if (pos == s.length()) {
            if (rl == 0 && rr == 0 && open == 0) {
                set.add(sb.toString());
                return;
            }
        }
        if (pos == s.length() || rl < 0 || rr < 0 || open < 0) return;
        int len = sb.length();
        if (s.charAt(pos) == '(') {
            dfs(s,rl-1,rr,open,pos+1,set,sb); // remove
            dfs(s,rl,rr,open+1,pos+1,set,sb.append("(")); // keep
        } else if (s.charAt(pos) == ')') {
            dfs(s,rl,rr-1,open,pos+1,set,sb); // remove
            dfs(s,rl,rr,open-1,pos+1,set,sb.append(")")); // keep
        } else {
            dfs(s,rl,rr,open,pos+1,set,sb.append(s.charAt(pos)));
        }
        
        sb.setLength(len);
    }
}
