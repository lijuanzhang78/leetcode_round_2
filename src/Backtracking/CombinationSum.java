package Backtracking;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), res, 0);
        return res;
    }
    
    void helper(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (target - candidates[i] < 0) break;
            list.add(candidates[i]);
            helper(candidates,target-candidates[i],list,res,i);
            list.remove(list.size()-1);
        }
    }
}
