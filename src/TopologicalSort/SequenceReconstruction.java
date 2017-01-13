package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SequenceReconstruction {
	public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Integer> indegree = new HashMap<Integer,Integer>();
        Map<Integer, List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
        
        for(int[] seq : seqs) {
            if (seq.length == 1) {
                if (!adjList.containsKey(seq[0])) adjList.put(seq[0],new ArrayList<Integer>());
                if (!indegree.containsKey(seq[0])) indegree.put(seq[0],0);
            } else {
                int prev = seq[0];
                int next = seq[1];
                if (!adjList.containsKey(prev)) adjList.put(prev,new ArrayList<Integer>());
                if (!adjList.containsKey(next)) adjList.put(next,new ArrayList<Integer>());
                adjList.get(prev).add(next);
                if (!indegree.containsKey(prev)) indegree.put(prev,0);
                if (!indegree.containsKey(next)) indegree.put(next,0);
                indegree.put(next,indegree.get(next)+1);
            }
        }
        
        if (indegree.size() != org.length) return false;
        Queue<Integer> q = new LinkedList<>();
        for(Integer v : indegree.keySet()) {
            if (indegree.get(v) == 0) q.offer(v);
        }
        int index = 0;
        while(q.size() > 0) {
            if (q.size() > 1) return false;
            int poll = q.poll();
            if (index == org.length || org[index++] != poll) return false;
            for(int nb : adjList.get(poll)) {
                indegree.put(nb, indegree.get(nb)-1);
                if (indegree.get(nb) == 0) q.offer(nb);
            }
        }
        return index == org.length;
    }
	
	public static void main(String[] args) {
		int[] org = {1,2,3};
		int[][] seqs = {{1,2},{1,3}};
		boolean res = new SequenceReconstruction().sequenceReconstruction(org, seqs);
	}
}
