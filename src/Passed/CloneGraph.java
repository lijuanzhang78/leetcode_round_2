package Passed;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode source = new UndirectedGraphNode(node.label);
        map.put(node.label, source);
        
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            
            for(UndirectedGraphNode nei : curr.neighbors) {
                if (!map.containsKey(nei.label)) {
                    UndirectedGraphNode newNode = new UndirectedGraphNode(nei.label);
                    map.put(nei.label, newNode);
                    queue.add(nei);
                }
                map.get(curr.label).neighbors.add(map.get(nei.label));
            }
        }
        return source;
    }
}
