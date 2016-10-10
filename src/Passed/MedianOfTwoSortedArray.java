package Passed;

public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int total = m + n;
        if (total % 2 != 0) {
            return helper(nums1, 0, m-1, nums2, 0, n-1, total/2+1);
        } else {
            return (helper(nums1, 0, m-1, nums2, 0, n-1, total/2) + helper(nums1, 0, m-1, nums2, 0, n-1, total/2+1))/2;
        }
    }
    
    double helper(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        if (m > n) return helper(B,bstart,bend,A,astart,aend,k);
        if (m == 0) return B[k-1];
        if (k == 1) return Math.min(A[astart], B[bstart]);
        
        int partA = Math.min(k/2, m);
        int partB = k - partA;
        if (A[astart+partA-1] < B[bstart+partB-1]) {
            return helper(A,astart+partA,aend,B,bstart,bend, k-partA);
        } else if (A[astart+partA-1] > B[bstart+partB-1]) {
            return helper(A,astart,aend,B,bstart+partB,bend, k-partB);
        } else {
            return A[astart+partA-1];
        }
    }
}
