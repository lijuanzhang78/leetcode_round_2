package Heap;

public class FindKPairsOfSmallestSum {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> nums1[a[0]]+nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        for(int i = 0; i < nums2.length; i++) {
            q.offer(new int[]{0,i});
        }
        k = Math.min(k,nums1.length*nums2.length);
        while(true) {
            int[] curr = q.poll();
            res.add(new int[]{nums1[curr[0]], nums2[curr[1]]});
            k--;
            if (k == 0) return res;
            if (curr[0] == nums1.length - 1) continue;
            q.offer(new int[]{curr[0]+1, curr[1]});
        }
    }
}
