package Passed;

import java.util.Arrays;

public class BinarySearch {
	public int binarySearch1(int[] A, int target) {
		Arrays.sort(A);
		int left = 0, right = A.length;
		
		while(left <= right) {
			System.out.println("["+left+","+right+"]");
			int mid = left + (right - left)/2;
			if (A[mid] > target) {
				right = mid - 1;
			} else if (A[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}			
		}
		return -1;		
	}
	
	public static void main(String[] args) {
		int[] A1 = {1,3,5,7,9,11,13};
		System.out.println(new BinarySearch().binarySearch1(A1, 5));	
	}

}
