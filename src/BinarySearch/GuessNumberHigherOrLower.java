package BinarySearch;

public class GuessNumberHigherOrLower {
	public int guessNumber(int n) {
        int start = 1, end = n;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if (guess(mid) == 1) {
                start = mid+1;
            } else if (guess(mid) == -1) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
