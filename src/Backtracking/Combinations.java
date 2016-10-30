package Backtracking;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) return res;
        
        helper(res,n,k,new ArrayList<Integer>(),1);
        return res;
    }
    
    void helper(List<List<Integer>> res, int n, int k, List<Integer> list, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = start; i <= n; i++) {
            list.add(i);
            helper(res,n,k,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
