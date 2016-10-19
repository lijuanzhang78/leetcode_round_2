package Sum_Questions;

import java.util.HashMap;
import java.util.Map;

// one pass
// 自己做的时候用的two pass
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                res[1] = i;
                res[0] = map.get(other);
                return res;
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}
