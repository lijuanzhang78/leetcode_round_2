package HashTable.Array;

public class ContainsDuplicatesIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i] + t); // 注意floor/ceiling的用法
            Integer ceiling = set.ceiling(nums[i]-t);// 
            if (floor != null && floor >= nums[i] ||
                ceiling != null && ceiling <= nums[i]) return true;
            set.add(nums[i]);
            if (i >= k) set.remove(nums[i-k]);
        }
        return false;
    }
}
