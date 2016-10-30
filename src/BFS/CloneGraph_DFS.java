package BFS;

public class CloneGraph_DFS {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        
        dfs(node,map);
        return root;
    }
    
    public void dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        for(UndirectedGraphNode adj : node.neighbors) {
            if (map.containsKey(adj.label)) {
                map.get(node.label).neighbors.add(map.get(adj.label));
            } else {
                UndirectedGraphNode newnode = new UndirectedGraphNode(adj.label);
                map.put(adj.label, newnode);
                map.get(node.label).neighbors.add(map.get(adj.label));
                dfs(adj,map);
            }
        }
    }
}
