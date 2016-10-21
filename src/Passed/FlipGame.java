package Passed;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        
        for(int i = 1; i <= s.length()-1; i++) {
            if (s.charAt(i-1) == '+' && s.charAt(i) == '+') {
                StringBuilder sb = new StringBuilder();
                if (i-1 > 0) sb.append(s.substring(0,i-1));
                sb.append("--");
                if (i< s.length()-1) sb.append(s.substring(i+1));
                res.add(sb.toString());
            }
        }
        return res;
    }
}
