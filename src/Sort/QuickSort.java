package Sort;

public class QuickSort {
	public void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);		
	}
	
	public void quickSort(int[] nums, int start, int end) {
		if (start >= end) return;
		int pIndex = partition(nums, start, end);
		quickSort(nums, start, pIndex-1);
		quickSort(nums, pIndex+1, end);		
	}
	
	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int pIndex = start;
		for(int i = start; i <= end-1; i++) {
			if (nums[i] <= pivot) {
				swap(nums, i, pIndex);
				pIndex++;				
			}
		}
		swap(nums, end, pIndex);
		return pIndex;		
	}
	
	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;		
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,5,3,7,1,9,2};
		new QuickSort().quickSort(nums);
		return;
	}
}
