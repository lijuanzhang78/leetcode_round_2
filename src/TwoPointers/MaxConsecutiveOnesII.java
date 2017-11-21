package TwoPointers;

public class MaxConsecutiveOnesII {
	public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;            
        }
        int start = 0, res = Integer.MIN_VALUE;
        int numzero = 0;
        for(int i = 0; i < nums.length; i++) {
            while( i < nums.length && (nums[i] == 1 || (nums[i] == 0 && numzero < 1))) {
                if (nums[i] == 0) numzero++;
                i++; 
            }
            res = Math.max(res,i-start);
            if (i < nums.length && nums[i] == 0 && numzero == 1) numzero++;
            if (numzero > 1 ) {
                while(start < nums.length && nums[start] == 1) {
                    start++;
                }
                start++;numzero--;                
            } 
        }
        return res == Integer.MIN_VALUE? 0 : res;        
	}
	
	public static void main(String[] args) {
		MaxConsecutiveOnesII test = new MaxConsecutiveOnesII();
		int[] nums = {1,0,1,1,0};
		int res = test.findMaxConsecutiveOnes(nums);
		return;	
	}
	

}
