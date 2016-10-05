package BinarySearch;

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        int[] res = {-1,-1};
        System.out.println("Look for lower bound!");
        while(low <= high) {
        	System.out.println("["+low+","+high+"]");
            int mid = low + (high - low)/2;
            if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
            System.out.println("["+low+","+high+"]");
        }
        int leftB = low;
        
        low = 0; high = nums.length - 1;
        System.out.println("Look for upper bound!");
        while(low <= high) {
        	System.out.println("["+low+","+high+"]");
            int mid = low + (high-low)/2;
            if (nums[mid] <= target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
            System.out.println("["+low+","+high+"]");
        }
        int rightB = high;
        if (leftB <= rightB) {
            res[0] = leftB;
            res[1] = rightB;
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,5,5,5,5,5,5,6,7,8,9};
		int[] res = new int[2];
		res = new SearchForARange().searchRange(nums, 5);		
	}
}
