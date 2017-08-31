package Backtracking;

public class FactorCombinations_3 {
	public List<List<Integer>> getFactors(int n) {
        if (n == 1) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        helper(n,res,temp,2);
        return res;       
    }
    
    void helper(int n, List<List<Integer>> res, List<Integer> temp, int start) {
        if (n == 1 && temp.size() > 1) {
            res.add(new ArrayList<Integer>(temp));
            return;            
        }
        
        for(int i = start; i <= n; i++) {
            if (n%i != 0) continue;
            temp.add(i);
            helper(n/i, res,temp,i);
            temp.remove(temp.size()-1);    
        }        
    }
}
