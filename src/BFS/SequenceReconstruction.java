package BFS;

public class SequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if (seqs == null || seqs.length == 0) return false;
        Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        for(int[] seq : seqs) {
            if (seq.length == 1) {
                if (!map.containsKey(seq[0])) map.put(seq[0], new HashSet<Integer>());
                if (!indegrees.containsKey(seq[0])) indegrees.put(seq[0], 0);
                continue;
            }
            
            for(int i = 0; i < seq.length - 1; i++) {
                int from = seq[i];
                int to = seq[i+1];
                if (!map.containsKey(from)) {
                    map.put(from, new HashSet<Integer>());
                }
                if (!map.containsKey(to)) {
                    map.put(to, new HashSet<Integer>());
                }
                if (!indegrees.containsKey(from)) indegrees.put(from,0);
                if (!indegrees.containsKey(to)) indegrees.put(to,0);
                if (map.get(from).add(to)) {
                    indegrees.put(to, indegrees.get(to)+1);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(Integer num : indegrees.keySet()) {
            if (indegrees.get(num) == 0) q.offer(num);
        }
        
        while(!q.isEmpty()) {
            if (q.size() > 1) return false;
            int curr = q.poll();
            res.add(curr);
            for(int adj : map.get(curr)) {
                indegrees.put(adj, indegrees.get(adj)-1);
                if (indegrees.get(adj) == 0) q.offer(adj);
            }
        }
        
        if (res.size() != indegrees.size()) return false;
        if (org.length != res.size()) return false;
        for(int i = 0; i < org.length; i++) {
            if (org[i] != res.get(i)) return false;
        }
        return true;
    }
}
