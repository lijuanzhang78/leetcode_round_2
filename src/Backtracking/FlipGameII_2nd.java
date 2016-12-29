package Backtracking;

public class FlipGameII_2nd {
	public boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i+1] == '+') {
                arr[i] = '-';
                arr[i+1] = '-';
                if (!canWin(new String(arr))) return true;
                arr[i] = '+';
                arr[i+1] = '+';
            }
        }
        return false;
    }
}
