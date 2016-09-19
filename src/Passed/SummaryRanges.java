package Passed;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        int[] curr = new int[2];
        curr[0] = nums[0];
        curr[1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == curr[1]+1) {
                curr[1] = nums[i];
            } else {
                if (curr[0] == curr[1]) {
                    res.add(String.valueOf(curr[0]));
                } else {
                    res.add(curr[0]+"->"+curr[1]);
                }
                
                curr[0] = nums[i];
                curr[1] = nums[i];
            }
        }
        if (curr[0] == curr[1]) {
            res.add(String.valueOf(curr[0]));
        } else {
            res.add(curr[0]+"->"+curr[1]);
        }
        return res;
    }
}
