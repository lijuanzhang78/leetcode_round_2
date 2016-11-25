package BinarySearch;

// Left boundary: 
// A[mid] < target: low = mid + 1;
// A[mid] == target: high = mid;
// A[mid] > target: high = mid - 1;
// combine case 2 and 3

public class SearchForARange_2nd {
	public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        int[] res = new int[2];
        // find the right bound
        while(low < high) {
            int mid = low + (high-low)/2 + 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        if (nums[low] != target) {
            res[1] = -1;
        } else {
            res[1] = low;
        }
        low = 0; high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[high] != target) {
            res[0] = -1;
        } else {
            res[0] = high;
        }
        return res;
    }

}
