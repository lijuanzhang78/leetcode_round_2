package HashTable.Array;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
