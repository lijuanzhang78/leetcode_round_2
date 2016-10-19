package Sum_Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i-1]) { // 去重
                int first = nums[i];
                int target = -nums[i];
                
                int j = i+1, k = nums.length - 1;
                while(j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        k--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(first);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                        j++; k--;
                        while(j < nums.length && nums[j] == nums[j-1]) j++; // 去重
                        while(k >= 0 && nums[k] == nums[k+1]) k--; // 去重
                    }
                }
            }
        }
        
        return res;
    }
}
