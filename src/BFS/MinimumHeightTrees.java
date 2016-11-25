package BFS;

// BFS topolofical sort
public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            for(int i = 0; i < n; i++) res.add(i);
            return res;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            int v0 = edge[0];
            int v1 = edge[1];
            adjList.get(v0).add(v1);
            adjList.get(v1).add(v0);
        }
        List<Integer> leaves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (adjList.get(i).size() == 1) leaves.add(i);
        }
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves) {
                List<Integer> adj = adjList.get(leaf);
                for(int adjLeaf : adj) {
                    adjList.get(adjLeaf).remove(Integer.valueOf(leaf));
                    if (adjList.get(adjLeaf).size() == 1) newLeaves.add(adjLeaf);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
