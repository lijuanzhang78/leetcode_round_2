package Passed;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                int sum2 = nums[i] + nums[j];
                if (!map.containsKey(sum2)) {
                    List<List<Integer>> list = new ArrayList<List<Integer>>();
                    map.put(sum2, list);
                    //List<Integer> pair = new ArrayList<Integer>();
                    //pair.add(i);pair.add(j);
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(i);pair.add(j);
                map.get(sum2).add(pair);
            }
        }
        
        for(Integer sum : map.keySet()) {
            if (map.containsKey(target - sum)) {
                for(List<Integer> list1 : map.get(sum)) {
                    for(List<Integer> list2 : map.get(target - sum)) {
                        boolean overlap = false;
                        for(int i : list1) {
                            for(int j : list2) {
                                if (i == j) overlap = true;
                            }
                        }
                        if(!overlap) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[list1.get(0)]);list.add(nums[list1.get(1)]);
                            list.add(nums[list2.get(0)]); list.add(nums[list2.get(1)]);
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }
            }
        }
        
        for(List<Integer> list : set) {
            res.add(list);
        }
        return res;
    }
}
