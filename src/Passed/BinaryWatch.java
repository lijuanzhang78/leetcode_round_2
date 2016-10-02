package Passed;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0) return res;
        int[] nums1 = {8,4,2,1};
        int[] nums2 = {32,16,8,4,2,1};
        
        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            helper(list1, nums1, i, 0, 0);
            helper(list2, nums2, num-i, 0, 0);
            for(Integer l1 : list1) {
                if (l1 > 11) continue;
                for(Integer l2 : list2) {
                    if (l2 > 59) continue;
                    res.add(l1 + ":" + (l2<10? "0"+l2 : l2));
                }
            }
        }
        return res;
    }
    
    void helper(List<Integer> res, int[] nums, int count, int pos, int sum) {
        if (count == 0) {
            res.add(sum);
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            helper(res, nums, count-1, i+1, sum+nums[i]);
        }
    }
}
