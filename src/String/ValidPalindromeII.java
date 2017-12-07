package String;

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while(low <= high) {
            if (arr[low] != arr[high]) {
                return isValid(arr,low+1,high) || isValid(arr,low,high-1);
            }
            low++;
            high--;
        }
        return true;    
    }
    
    boolean isValid(char[] arr, int low, int high) {
        while(low <= high) {
            if (arr[low] != arr[high]) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        return true;    
    }
}
