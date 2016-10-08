package DisjointSet;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAUndirectedGraph {
	private int[] parents;
    public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            return n;
        }
        Set<Integer> set = new HashSet<>();
        
        parents = new int[n];
        // make sets
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        // union sets
        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        
        for(int i = 0; i < n; i++) {
            set.add(findSet(i));
        }
        return set.size();
    }
    
    private void union(int i, int j) {
        int p1 = findSet(i);
        int p2 = findSet(j);
        parents[p1] = p2;
    }
    
    private int findSet(int i) {
        if (parents[i] == i) return i;
        parents[i] = findSet(parents[i]);
        return parents[i];
    }
    
    
    
    
}
