package Passed;

public class SortedTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) return res;
        
        int index = 0;
        if (a >= 0) index = nums.length - 1;
        int i = 0, j = nums.length - 1;
        
        while(i <= j) {
            if (a >= 0) {
                res[index--] = getValue(a,b,c,nums[i]) >= getValue(a,b,c,nums[j])? getValue(a,b,c,nums[i++]) : getValue(a,b,c,nums[j--]);
            } else {
                res[index++] = getValue(a,b,c,nums[i]) <= getValue(a,b,c,nums[j])? getValue(a,b,c,nums[i++]) : getValue(a,b,c,nums[j--]);
            } 
        }
        return res;
    }
    
    private int getValue(int a, int b, int c, int x) {
        return a*x*x + b*x + c;
    }
}
