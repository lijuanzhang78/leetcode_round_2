package Passed;

public class KthSmallestElementInASortedMatrix {
	public class Node {
        int val;
        int x;
        int y;
        
        public Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b) -> (a.val - b.val));
        pq.offer(new Node(matrix[0][0], 0, 0));
        visited[0][0] = true;
        
        
        int count = 0;
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            count++;
            if (count == k) return matrix[curr.x][curr.y];
            if (curr.x + 1 < m && !visited[curr.x+1][curr.y]) {
                pq.offer(new Node(matrix[curr.x+1][curr.y], curr.x+1, curr.y));
                visited[curr.x+1][curr.y] = true;
            }
            if (curr.y + 1 < n && !visited[curr.x][curr.y+1]) {
                pq.offer(new Node(matrix[curr.x][curr.y+1], curr.x, curr.y+1));
                visited[curr.x][curr.y+1] = true;
            }
        }
        return 0;
    }
}
