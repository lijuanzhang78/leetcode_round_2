package Passed;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) return;
        
        int[] arr1 = new int[m];
        for(int i = 0; i < m; i++) {
            arr1[i] = nums1[i];
        }
        
        int i = 0, j = 0;
        int index = 0;
        while(i < m || j < n) {
            if (i < m && j < n) {
                if (arr1[i] <= nums2[j]) {
                    nums1[index] = arr1[i];
                    i++;index++;
                } else {
                    nums1[index] = nums2[j];
                    j++;index++;
                }
            } else if (i < m) {
                nums1[index] = arr1[i];
                i++;index++;
            } else {
                nums1[index] = nums2[j];
                j++;index++;
            }
                
        }
        return;
    }

}
