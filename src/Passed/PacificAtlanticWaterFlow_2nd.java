package Passed;

public class PacificAtlanticWaterFlow_2nd {
	int m = 0;
    int n = 0;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            dfs(matrix,pacific,i,0,Integer.MIN_VALUE);
            dfs(matrix,atlantic,i,n-1,Integer.MIN_VALUE);
        }
        for(int i = 0; i < n; i++) {
            dfs(matrix,pacific,0,i,Integer.MIN_VALUE);
            dfs(matrix,atlantic,m-1,i,Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }
    
    void dfs(int[][] matrix,boolean[][] visited, int i, int j, int height) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        if (matrix[i][j] < height) return;
        
        visited[i][j] = true;
        dfs(matrix,visited,i+1,j,matrix[i][j]);
        dfs(matrix,visited,i-1,j,matrix[i][j]);
        dfs(matrix,visited,i,j+1,matrix[i][j]);
        dfs(matrix,visited,i,j-1,matrix[i][j]);
    }
}
