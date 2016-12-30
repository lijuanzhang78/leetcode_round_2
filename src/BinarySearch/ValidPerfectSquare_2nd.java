package BinarySearch;

// important to claim both low, high, mid as long

public class ValidPerfectSquare_2nd {
	public boolean isPerfectSquare(int num) {
        long low = 0, high = num;
        
        while(low <= high) {
            long mid = low + (high-low)/2;
            if (mid*mid == num) {
                return true;
            } else if (mid*mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
