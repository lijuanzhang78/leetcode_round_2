package Passed;

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        int[] res = {-1,-1};
        while(low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        int leftB = low;
        
        low = 0; high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (nums[mid] <= target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        int rightB = high;
        if (leftB <= rightB) {
            res[0] = leftB;
            res[1] = rightB;
        }
        return res;
    }
}
