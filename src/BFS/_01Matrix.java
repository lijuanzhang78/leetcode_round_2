package BFS;

public class _01Matrix {
	public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0) return new int[0][0];
        Queue<int[]> q = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new int[]{i,j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        int count = 0;
        int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >= m || x < 0 || y >= n || y < 0) continue;
                    if (matrix[x][y] > count + 1) {
                        matrix[x][y] = count + 1;
                        q.add(new int[]{x,y});
                    } 
                }
            }
            count++;
        }
        return matrix;
    }

}
