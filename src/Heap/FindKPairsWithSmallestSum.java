package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new ArrayList<int[]>();
        
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        int len1 = nums1.length, len2 = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (nums1[a[0]]+nums2[a[1]]) - (nums1[b[0]]+nums2[b[1]]));
        pq.offer(new int[]{0,0});
        
        List<int[]> res = new ArrayList<int[]>();
        while(res.size() < k && pq.size() > 0) {
            int[] curr = pq.poll();
            res.add(new int[]{nums1[curr[0]], nums2[curr[1]]});
            if (curr[0]+1 < len1 && !visited[curr[0]+1][curr[1]]) {
                pq.offer(new int[]{curr[0]+1,curr[1]});
                visited[curr[0]+1][curr[1]] = true;
            }
            if (curr[1]+1 < len2 && !visited[curr[0]][curr[1]+1]) {
                pq.offer(new int[]{curr[0],curr[1]+1});
                visited[curr[0]][curr[1]+1] = true;
            }
        }
        //if (res.size() < k && pq.size() == 0) return new ArrayList<int[]>();
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,1,2};
		int[] nums2 = {1,2,3};
		int k = 10;
		List<int[]> res = new FindKPairsWithSmallestSum().kSmallestPairs(nums1, nums2, k);		
	}
}
