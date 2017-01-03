package Array;

public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num-1] > 0) nums[num-1] = -nums[num-1];
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i+1);
        }
        return res;
    }
}
