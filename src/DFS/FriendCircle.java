package DFS;

public class FriendCircle {
	public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) return 0;
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for(int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }
    
    void dfs(int[][] M, boolean[] visited, int i) {
        visited[i] = true;
        for(int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(M,visited,j);
            }
        }
    }
}
