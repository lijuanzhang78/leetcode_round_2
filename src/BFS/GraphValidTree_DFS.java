package BFS;

// 有向无向图判断有没有cycle
// DFS比较好用，无向图需要skip parent
//
public class GraphValidTree_DFS {
	public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            if (n == 1) return true;
            return false;
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        visited[0] = 1;
        if (!dfs(adjList,0,-1,visited)) return false;
        
        for(int v : visited) {
            if (v == 0) return false;
        }
        return true;
    }
    
    boolean dfs(List<List<Integer>> adjList, int curr, int prev, int[] visited) {
        for(int adj : adjList.get(curr)) {
            if (adj == prev) continue;
            if (visited[adj] == 1) return false;
            if (visited[adj] == 0) {
                visited[adj] = 1;
                if (!dfs(adjList,adj,curr,visited)) return false;
            }
        }
        visited[curr] = 2;
        return true; // 不要忘记了
    }
}
