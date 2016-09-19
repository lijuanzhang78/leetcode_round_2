package Passed;

public class NQueensII {
	int res;
    public int totalNQueens(int n) {
        res = 0;
        int[] cols = new int[n];
        helper(cols, 0, n);
        return res;
    }
    
    private void helper(int[] cols, int currRow, int n) {
        if (currRow == n) {
            res++;
            return;
        }
        
        for(int j = 0; j < n; j++) {
            cols[currRow] = j;
            if (isValid(cols,n, currRow)) {
                helper(cols, currRow+1, n);
            }
        }
    }
    
    private boolean isValid(int[] cols, int n, int currRow) {
        for(int i = 0; i < currRow; i++) {
            if (cols[i] == cols[currRow]) return false;
            if (Math.abs(cols[currRow]-cols[i]) == currRow - i) return false;
        }
        
        return true;
    }
}
