package Backtracking;

// avoid adding n

public class FactorCombination_2nd {
	public List<List<Integer>> getFactors(int n) {
        if (n == 1) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        dfs(n,2,temp,res);
        return res;
    }
    
    void dfs(int n, int start, List<Integer> temp, List<List<Integer>> res) {
        if (n == 1) {
            if (temp.size() > 1) res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = start; i <= n; i++) {
            if (n % i == 0) {
                temp.add(i);
                dfs(n/i,i,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
}
