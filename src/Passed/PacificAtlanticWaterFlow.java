package Passed;

public class PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i < matrix.length; i++) {
            dfs(matrix,i,0,pacific,Integer.MIN_VALUE);
            dfs(matrix,i,n-1,atlantic,Integer.MIN_VALUE);
        }
        for(int j = 0; j < matrix[0].length; j++) {
            dfs(matrix,m-1,j,atlantic,Integer.MIN_VALUE);
            dfs(matrix,0,j,pacific,Integer.MIN_VALUE);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (pacific[i][j]&&atlantic[i][j]) res.add(new int[]{i,j});
            }
        }
        return res;
    }
    
    void dfs(int[][] matrix, int i, int j, boolean[][] visited, int height) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j]) return;
        if (matrix[i][j] < height) return;
            
        visited[i][j] = true;
        dfs(matrix,i+1,j,visited,matrix[i][j]);
        dfs(matrix,i-1,j,visited,matrix[i][j]);
        dfs(matrix,i,j+1,visited,matrix[i][j]);
        dfs(matrix,i,j-1,visited,matrix[i][j]);
    }
}
