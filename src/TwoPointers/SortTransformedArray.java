package TwoPointers;

// two pointers

public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0) return new int[0];
        int low = 0, high = nums.length - 1;
        int[] res = new int[nums.length];
        int index = a >= 0? nums.length - 1 : 0;
        while(low <= high) {
            int l = nums[low], h = nums[high];
            int rl = a*l*l + b*l + c;
            int rr = a*h*h + b*h + c;
            if (a >= 0) {
                if (rr >= rl) {
                    res[index] = rr;
                    high--;
                } else {
                    res[index] = rl;
                    low++;
                }
                index--;
            } else {
                if (rl < rr) {
                    res[index] = rl;
                    low++;
                } else {
                    res[index] = rr;
                    high--;
                }
                index++;
            }
        }
        return res;
    }	
}
