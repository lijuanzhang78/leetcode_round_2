package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> res = new ArrayList<>();
	        if (n < 1 || k < 1) return res;
	        
	        helper(k,n,new ArrayList<Integer>(),res,1);
	        return res;
	    }
	    
	    void helper(int k, int target, List<Integer> list, List<List<Integer>> res, int start) {
	        if (target > 0 && list.size() >= k) {
	            return;
	        }
	        if (target == 0 && list.size() == k) {
	            res.add(new ArrayList<Integer>(list));
	            return;
	        }
	        //if (start > 9) return; // 这一步多余
	        for(int i = start; i <= 9; i++) {
	            if (target-i < 0) break;
	            list.add(i);
	            helper(k,target-i,list,res,i+1);
	            list.remove(list.size()-1);
	        }
	    }
}
