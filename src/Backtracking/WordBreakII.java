package Backtracking;

public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return res;
        
        if (!isValid(s,wordDict)) return res;
        helper(res, s, wordDict, 0, "");
        return res;
    }
    
    void helper(List<String> res, String s, Set<String> wordDict, int start, String curr) {
        if (start == s.length()) {
            res.add(new String(curr.trim()));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            String str = s.substring(start,i+1);
            if (wordDict.contains(str)) {
                curr += str + " ";
                helper(res,s,wordDict,i+1,curr);
                curr = curr.substring(0,curr.length()-str.length()-1);
            }
        }
    }
    
    boolean isValid(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}
