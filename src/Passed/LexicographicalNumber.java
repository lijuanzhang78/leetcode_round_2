package Passed;

public class LexicographicalNumber {
	public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if (n < 1) return res;
        
        helper(0, res, n);
        
        return res;
    }
    
    void helper(int prev, List<Integer> res, int n) {
        
        for(int i = 0; i <= 9; i++) {
            if (prev == 0 && i == 0) continue;
            
            Integer curr = prev*10 + i;
            if (curr <= n) {
                res.add(curr);
                helper(curr, res, n);
            } else {
                break;
            }
        }
    }

}
