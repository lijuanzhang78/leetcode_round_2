package BinarySearch;

public class ArrangeCoins {
	public int arrangeCoins(int n) {
        long start = 1, end = n;
        long nlong = (long)n;
        while(start <= end) {
            long mid = start + (end - start)/2;
            if (mid*(mid+1) > 2*nlong) {
                end = mid-1;
            } else if (mid*(mid+1) < 2*nlong) {
                start = mid+1;
            } else {
                return (int)mid;
            }
        }
        return (int)end;
    }
}
