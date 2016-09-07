package Passed;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        
        helper(res, list, 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int k, int n) {
        if (list.size() == k) {
            int sum = 0;
            for(int num : list) {
                sum += num;
            }
            if (sum == n ) {
                res.add(new ArrayList<Integer>(list));
            }
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, i+1, k, n);
            list.remove(list.size()-1);
        }
    }
}
