package BitManipulation;

public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                count += (nums[j] >> i) & 1;
            }
            res += count*(nums.length-count);
        }
        return res;
    }
}
