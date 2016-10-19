package Sum_Questions;

// 经典two pointers
public class TwoSum_inputSorted {
	public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) return null;
        
        int i = 0, j = numbers.length - 1;
        int[] res = new int[2];
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
}
