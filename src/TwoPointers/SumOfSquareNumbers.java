package TwoPointers;

public class SumOfSquareNumbers {
	public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int end = (int) Math.sqrt(c);
        int left = 0, right = end;
         while(left <= right) {
             if (left*left + right*right < c) {
                 left++;
             } else if (left*left + right*right > c) {
                 right--;
             } else {
                 return true;
             }             
         }
        return false;        
    }
}
