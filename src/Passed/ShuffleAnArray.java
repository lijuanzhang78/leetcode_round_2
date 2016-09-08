package Passed;

public class ShuffleAnArray {
	int[] nums = null;
    Random rand = null;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOf(nums, nums.length);
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ans = Arrays.copyOf(nums, nums.length);
        for(int i = 1; i < ans.length; i++) {
            int swapIndex = rand.nextInt(i+1);
            swap(ans, swapIndex, i);
        }
        
        return ans;
    }
    
    void swap(int[] ans, int swap, int i) {
        int temp = ans[swap];
        ans[swap] = ans[i];
        ans[i] = temp;
    }
}
