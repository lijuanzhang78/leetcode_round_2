package Passed;

public class ExpressionAddOperators_DFS {
	public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(num, target, sb, res, 0, 0, 0);
        return res;
    }
    
    private void dfs(String num, int target, StringBuilder sb, List<String> res, int pos, long prev, long offset) {
        if (pos == num.length()) {
            if (prev == target) {
                res.add(sb.toString());
                return;
            }
        }
        
        for(int i = pos; i < num.length(); i++) {
            if (num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i+1));
            int len = sb.length();
            if (pos == 0) {
                dfs(num, target, sb.append(curr), res, i+1, curr, curr);
                sb.setLength(0);
            } else {
                dfs(num, target, sb.append("+").append(curr), res, i+1, prev+curr, curr);
                sb.setLength(len);
                dfs(num, target, sb.append("-").append(curr), res, i+1, prev-curr, -curr);
                sb.setLength(len);
                dfs(num, target, sb.append("*").append(curr), res, i+1, prev-offset+offset*curr, offset*curr);
                sb.setLength(len);
            }
        }
    }
}
