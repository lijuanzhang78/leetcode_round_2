package Passed;

public class AndroidUnlockPattern {
	int[][] dir1 = {{0,1}, {0,-1}, {1,0}, {-1,0},
            {1,1}, {1,-1}, {-1,1}, {-1,-1},
            {1,2}, {1,-2}, {-1,2}, {-1,-2},
            {2,1}, {2,-1}, {-2,1}, {-2,-1}};
            
int[][] dir2 = {{0,2}, {0,-2}, {2,0}, {-2,0}};
int[][] dir3 = {{2,2}, {-2,2}, {2,-2}, {-2,-2}};
int res = 0;
public int numberOfPatterns(int m, int n) {
boolean[][] visited = new boolean[3][3];
for(int i = 0; i < 3; i++) {
    for(int j = 0; j < 3; j++) {
        dfs(i,j, m, n, 0, visited);
    }
}
return res;
}

private void dfs(int i, int j, int m, int n, int len, boolean[][] visited) {
if (visited[i][j]) return;
visited[i][j] = true;
len++;

if (len >= m && len <= n) {
    res++;
} else if (len > n) {
    visited[i][j] = false;
    return;
}


for(int[] dir : dir1) {
    int x = i + dir[0];
    int y = j + dir[1];
    if (x >= 3 || x < 0 || y >= 3 || y < 0) continue;
    dfs(x, y, m, n, len, visited);
}


for(int[] dir : dir2) {
    int x = i + dir[0];
    int y = j + dir[1];
    int x0 = i + dir[0]/2;
    int y0 = j + dir[1]/2;
    if (x >= 3 || x < 0 || y >= 3 || y < 0 || !visited[x0][y0]) continue;
    dfs(x, y, m, n, len, visited);
}

for(int[] dir : dir3) {
    int x = i + dir[0];
    int y = j + dir[1];
    if (x >= 3 || x < 0 || y >= 3 || y < 0 || !visited[1][1]) continue;
    dfs(x, y, m, n, len, visited);
}
visited[i][j] = false;
}

}
