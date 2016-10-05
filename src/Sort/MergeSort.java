package Sort;

public class MergeSort {
	public void mergeSort(int[] nums) {
		if (nums.length < 2) return;
		int[] left = new int[nums.length/2];
		int[] right = new int[nums.length - nums.length/2];
		for(int i = 0; i < nums.length/2; i++) {
			left[i] = nums[i];			
		}
		for(int i = nums.length/2; i < nums.length; i++) {
			right[i-nums.length/2] = nums[i]; 
		}
		mergeSort(left);
		mergeSort(right);
		merge(nums, left, right);		
	}
	
	private void merge(int[] nums, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				nums[k++] = left[i++];
			} else {
				nums[k++] = right[j++];
			}			
		}		
		while(i < left.length) {
			nums[k++] = left[i++];
		}
		while(j < right.length) {
			nums[k++] = right[j++];
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,6,5,9,2,1,0};
		new MergeSort().mergeSort(nums);
		return;
	}
}
