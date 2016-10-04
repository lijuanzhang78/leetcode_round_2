package Passed;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row*col-1;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            if (matrix[mid/col][mid%col] < target) {
                start = mid + 1;
            } else if (matrix[mid/col][mid%col] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
