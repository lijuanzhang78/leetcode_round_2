package BinarySearch;

public class BinarySearch {
	public int binarySearch(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		while(low <= high) {
			System.out.println("["+low+","+high+"]");
			int mid = low + (high-low)/2;
			if (nums[mid] < target) {
				low = mid + 1;				
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				System.out.println("Found! " + mid);
				return mid;
			}
			System.out.println("["+low+","+high+"]");
			
		}
		
		System.out.println("can not find!");
		return -1;		
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1,3,5,6,9,12};
		int[] nums2 = {2,4,7,9,10,13,16};
		int res1 = new BinarySearch().binarySearch(nums1, 0);
		int res2 = new BinarySearch().binarySearch(nums2, 17);	
	}
}
