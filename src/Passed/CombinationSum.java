package Passed;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        
        helper(res, temp, candidates, 0, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int start, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        } 
        
        if (target < 0) return;
        
        for(int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(res, temp, candidates, i, target-candidates[i]);
            temp.remove(temp.size()-1);
            if (target-candidates[i] < 0) break;
        }
    }
}
