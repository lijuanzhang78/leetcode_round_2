package UnionFind;

public class NumberOfIslands {
	int[] parents;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0, m = grid.length, n = grid[0].length;
        parents = new int[m*n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    parents[i*n+j] = i*n+j;
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                if (i-1 >= 0 && grid[i-1][j] == '1') {
                    int p0 = findSet(i*n+j);
                    int p1 = findSet((i-1)*n+j);
//                  注意不能写成下面这样
//                    if (findSet((i-1)*n+j) != findSet(i*n+j)) {
//                       parents[i*n+j] = parents[(i-1)*n+j]
                    if (p0 != p1) {
                        parents[p0] = p1;
                        count--;
                    }
                }
                
                if (i+1 < m && grid[i+1][j] == '1') {
                    int p0 = findSet(i*n+j);
                    int p1 = findSet((i+1)*n+j);
                    if (p0 != p1) {
                        parents[p0] = p1;
                        count--;
                    }
                }
                if (j-1 >= 0 && grid[i][j-1] == '1') {
                    int p0 = findSet(i*n+j);
                    int p1 = findSet(i*n+j-1);
                    if (p0 != p1) {
                        parents[p0] = p1;
                        count--;
                    }
                }
                if (j+1 < n && grid[i][j+1] == '1') {
                    int p0 = findSet(i*n+j);
                    int p1 = findSet(i*n+j+1);
                    if (p0 != p1) {
                        parents[p0] = p1;
                        count--;
                    }
                }
                
            }
        }
        return count;
    }
    
    int findSet(int i) {
        if (parents[i] != i) {
            parents[i] = findSet(parents[i]);
        }
        return parents[i];
    }
    
    public static void main(String[] args) {
    	char[][] grid = {{'1','1','1','1','0'},
    					 {'1','1','0','1','0'},
    					 {'1','1','0','0','0'},
    					 {'0','0','0','0','0'}};
    	int res = new NumberOfIslands().numIslands(grid);    	
    }    
}
