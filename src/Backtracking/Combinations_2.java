package Backtracking;

public class Combinations_2 {
	public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n) return new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(res,temp,1,n,k);
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> temp, int start, int n, int max) {
        if (temp.size() == max) {
            res.add(new ArrayList<Integer>(temp));
            return;            
        }
        for(int i = start; i <= n; i++) {
            temp.add(i);
            helper(res,temp,i+1,n,max);
            temp.remove(temp.size()-1);    
        }        
    }     
}
