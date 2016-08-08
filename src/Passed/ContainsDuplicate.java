package Passed;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num,1);
            }
        }
        return false;
    }
}
