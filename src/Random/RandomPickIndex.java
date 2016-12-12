package Random;

public class RandomPickIndex {
	int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) res = i;
            }
        }
        return res;
    }
}
