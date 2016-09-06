package Passed;

public class TwoSumIIInputArraySorted {
	public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return new int[2];
        
        int n = numbers.length;
        int i = 0, j = n - 1;
        while(i < j) {
            if (i < n && j >= 0 && numbers[i] + numbers[j] > target) {
                j--;
            }  else if (i < n && j >= 0 && numbers[i] + numbers[j] < target) {
                i++;
            } else if (i < n && j >= 0 && numbers[i] + numbers[j] == target) {
                return new int[]{i+1, j+1};
            }
        }
        return new int[2];
    }
}
