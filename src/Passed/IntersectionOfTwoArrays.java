package Passed;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            if (set1.contains(num)) {
                intersect.add(num);
            }
        }
        
        int n = intersect.size();
        int[] res = new int[n];
        int i = 0;
        for(int num : intersect) {
            res[i++] = num;
        }
        return res;
    }
}
