package Heap;

public class KthSmallestInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        for(int j = 0; j < matrix[0].length; j++) {
            q.offer(new int[]{0,j});
        }
        int[] curr = new int[2];
        while(true) {
            curr = q.poll();
            k--;
            if (k == 0) break;
            if (curr[0] == m - 1) continue;
            q.offer(new int[]{curr[0]+1,curr[1]});
        }
        return matrix[curr[0]][curr[1]];
    }
}
