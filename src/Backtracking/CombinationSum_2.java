package Backtracking;

public class CombinationSum_2 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(res,temp,0,0,target,candidates);
        return res;      
    }
    
    void helper(List<List<Integer>> res, List<Integer> temp, int start, int sum, int target, int[] candidates) {
        if (sum == target) {
            res.add(new ArrayList<Integer> (temp));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            if (candidates[i] > target - sum) break;
            temp.add(candidates[i]);
            helper(res,temp,i,sum+candidates[i],target,candidates);
            temp.remove(temp.size()-1);            
        }        
    }  
}
