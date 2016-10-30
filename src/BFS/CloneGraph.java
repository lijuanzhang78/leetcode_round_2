package BFS;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        q.offer(node);
        
        while(!q.isEmpty()) {
            UndirectedGraphNode curr = q.poll();
            for(UndirectedGraphNode adj : curr.neighbors) {
                if (!map.containsKey(adj.label)) {
                    UndirectedGraphNode newnode = new UndirectedGraphNode(adj.label);
                    q.offer(adj);
                    map.put(newnode.label, newnode);
                    map.get(curr.label).neighbors.add(newnode);
                } else {
                    map.get(curr.label).neighbors.add(map.get(adj.label));
                }
                    
            }
        }
        return root;
	}
}
