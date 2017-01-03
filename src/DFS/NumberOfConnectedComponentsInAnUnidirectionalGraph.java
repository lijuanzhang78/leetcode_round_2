package DFS;

public class NumberOfConnectedComponentsInAnUnidirectionalGraph {
	public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return n;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(adjList,visited,i);
            }
        }
        return res;
    }
    
    void dfs(List<List<Integer>> adjList, boolean[] visited, int curr) {
        visited[curr] = true;
        for(int adj : adjList.get(curr)) {
            if (!visited[adj]) dfs(adjList,visited,adj);
        }
    }
}
