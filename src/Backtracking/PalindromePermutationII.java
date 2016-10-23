package Backtracking;

// 细节很多的一道题
public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        if (isValid(s,map)) {
            StringBuilder sb = new StringBuilder();
            String mid = "";
            for(Character ch : map.keySet()) {
                if (map.get(ch)%2 != 0) mid += ch;
                for(int i = 0; i < map.get(ch)/2;i++) {
                    sb.append(ch);
                }
            } 
            boolean[] visited = new boolean[sb.length()];
            helper(sb.toString(), new StringBuilder(), res,visited,mid);
        } 
        return res;
    }
    
    void helper(String s, StringBuilder sb, List<String> res, boolean[] visited, String mid) {
        if (sb.length() == s.length()) {
            res.add(sb.toString()+mid+sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i-1) && !visited[i-1]) continue;
            if (!visited[i]) {
                visited[i] = true;
                sb.append(s.charAt(i));
                helper(s,sb,res,visited,mid);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    private boolean isValid(String s, Map<Character,Integer> map) {
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch,1);
            }
        }
        
        int numSig = 0;
        for(Character ch : map.keySet()) {
            if (map.get(ch) % 2 != 0) {
                numSig++;
            }
        }
        if (numSig > 1) return false;
        return true;
    }
}
