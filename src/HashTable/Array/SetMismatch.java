package HashTable.Array;

public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for(int num : nums) {
            if (set.contains(num)) {
                res[0] = num;
            } else {
                set.add(num);
            }
            sum += num;
        }
        
        int n = nums.length;
        res[1] = res[0] + (n*(n+1)/2 - sum);
        return res;        
    }
}
