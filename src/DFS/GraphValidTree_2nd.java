package DFS;

public class GraphValidTree_2nd {
	public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            if (n == 1) return true;
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        if(!dfs(0,visited,adjList,-1)) return false;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    
    boolean dfs(int curr, boolean[] visited, List<List<Integer>> adjList, int parent) {
        visited[curr] = true;
        for(int adj : adjList.get(curr)) {
            if (visited[adj] && adj != parent) return false;
            if (visited[adj]) continue; // this is important
            if (!dfs(adj,visited,adjList,curr)) return false;
        }
        return true;
    }
}
