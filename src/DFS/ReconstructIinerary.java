package DFS;

// 欧拉通路问题
// 也可以用backtracking

public class ReconstructIinerary {
	public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<String>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) return res;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        buildGraph(map,tickets);
        Set<String> visited = new HashSet<>();
        
        dfs("JFK",map,visited,res);
        return res;
    }
    
    void dfs(String curr, Map<String,PriorityQueue<String>> map, Set<String> visited, LinkedList<String> res) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            String adj = map.get(curr).poll();
            dfs(adj,map,visited,res);
        }
        res.addFirst(curr);
    }
    
    void buildGraph(Map<String, PriorityQueue<String>> map, String[][] tickets) {
        for(String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<String>());
            }
            map.get(from).offer(to);
        }
    }
}
