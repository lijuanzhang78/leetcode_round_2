package Passed;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (n <= 0) return res;
        int[] cols = new int[n];
        
        helper(res, cols, 0, n);
        return res;
    }
    
    void helper(List<List<String>> res, int[] cols, int currRow, int n) {
        if (currRow == n) {
            drawBoard(res, cols);
            return;
        }
        
        for(int j = 0; j < n; j++) {
            cols[currRow] = j;
            if (isValid(cols, currRow)) {
                helper(res, cols, currRow+1, n);
            }
        }
    }
    
    boolean isValid(int[] cols, int currRow) {
        for(int i = 0; i < currRow; i++) {
            if (cols[i] == cols[currRow]) return false;
            if (Math.abs(cols[i]- cols[currRow]) == currRow - i) return false;
        }
        return true;
    }
    
    void drawBoard(List<List<String>> res, int[] cols) {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < cols.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < cols.length; j++) {
                if (j == cols[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
