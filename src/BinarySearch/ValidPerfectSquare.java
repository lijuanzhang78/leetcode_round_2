package BinarySearch;

public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        long start = 0, end = num;
        while(start <= end) {
            long mid = start + (end-start)/2;
            if (mid*mid > num) {
                end = mid-1;
            } else if (mid*mid < num) {
                start = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }
}
