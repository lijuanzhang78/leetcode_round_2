package Backtracking;

import java.util.ArrayList;
import java.util.List;

// 这道题挺有意思

public class FactorCombination {
	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) return res;
        helper(res,n,new ArrayList<Integer>(), 2, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, int target, List<Integer> list, int start, int n) {
        if (target == 1) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (start > target) return;
        
        for(int i = start; i <= target; i++) {
            if (target == n && i == target) continue; // 防止n本身被加进去
            if (target%i == 0) {
                list.add(i);
                helper(res,target/i,list,i,n);
                list.remove(list.size()-1);
            }
        }
    }
	
    public static void main(String[] args) {
    	List<List<Integer>> res = new FactorCombination().getFactors(12);    	
    }

}
