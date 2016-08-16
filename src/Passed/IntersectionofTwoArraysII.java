package Passed;

public class IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        
        Map<Integer, int[]> map = new HashMap<>();
        for(int num : nums1) {
            if (!map.containsKey(num)) {
                int[] count = new int[2];
                map.put(num, count);
            }
            int[] count = map.get(num);
            count[0]++; count[1]++;
        }
        
        for(int num : nums2) {
            if (map.containsKey(num)) {
                int[] count = map.get(num);
                if (count[1] > 0) count[1]--;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(Integer num : map.keySet()) {
            int[] count = map.get(num);
            int diff = count[0] - count[1];
            while(diff > 0) {
                res.add(num);
                diff--;
            }
        }
        int[] resarr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resarr[i] = res.get(i);
        }
        return resarr;
    }
}
