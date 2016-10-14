package Passed;

public class KthLargestElementInAnArray_quickSelect {
	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while(true) {
            int pIndex = partition(nums,low,high);
            if (pIndex < k) {
                low = pIndex + 1;
            } else if (pIndex > k) {
                high = pIndex - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int pIndex = low;
        for(int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                swap(nums,i,pIndex);
                pIndex++;
            }
        }
        swap(nums,pIndex,high);
        return pIndex;
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
