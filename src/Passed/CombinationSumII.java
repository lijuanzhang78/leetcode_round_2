package Passed;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, res,list,0,target);
        return res;
    }
    
    void helper(int[] candidates, List<List<Integer>> res, List<Integer> list, int start, int target) {
            if (target < 0) {
                return;
            }
            
            if (target == 0) {
                res.add(new ArrayList<Integer>(list));
                return;
            }
            
            if (start == candidates.length) return;
            
            for(int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) continue;
                list.add(candidates[i]);
                helper(candidates, res, list, i+1, target-candidates[i]);
                list.remove(list.size()-1);
                if (target-candidates[i] < 0) break;
            }
    }
}
