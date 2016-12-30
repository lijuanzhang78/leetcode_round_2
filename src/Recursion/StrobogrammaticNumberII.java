package Recursion;

public class StrobogrammaticNumberII {
	char[] opt = {'0','1','6','8','9'};
    char[] sin = {'0','1','8'};
    Map<Character,Character> map;
    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) return new ArrayList<String>();
        map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        
        List<String> res = new ArrayList<String>();
        dfs(res,n,0,"");
        return res;
    }
    
    void dfs(List<String> res, int n, int count, String curr) {
        if (count == n/2) {
            buildfull(res, curr, n);
            return;
        }
        
        for(int i = 0; i < opt.length; i++) {
            if (count == 0 && opt[i] == '0') continue;
            dfs(res,n,count+1,curr+opt[i]);
        }
    }
    
    void buildfull(List<String> res, String half, int n) {
        if (n % 2 > 0) {
            for(int i = 0; i < sin.length; i++) {
                String temp = half+sin[i];
                for(int j = half.length()-1; j >= 0; j--) {
                    char ch = half.charAt(j);
                    temp += map.get(ch);
                }
                res.add(temp);
            }
        } else {
            String temp = new String(half);
            for(int j = half.length()-1; j >= 0; j--) {
                char ch = half.charAt(j);
                temp += map.get(ch);
            }
            res.add(temp);
        }
    }
}
