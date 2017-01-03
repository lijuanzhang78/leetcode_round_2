package Array;

// similar to 'find all numbers disappeared in An Array'

public class FindAllDuplicatedInAnArray {
	public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num-1] > 0) {
                nums[num-1] = -nums[num-1];
                continue;
            }
            if (nums[num-1] < 0) {
                res.add(num);
            }
        }
        return res;
    }
}
