package UnionFind;

public class NumberOfConnectedComponentsInAnUndirectionalGraph {
	public int countComponents(int n, int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return n;
        int[] parents = new int[n];
        // make sets
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int count = n;
        for(int[] e : edges) {
            int p0 = findSet(e[0],parents);
            int p1 = findSet(e[1],parents);
            if (p0 != p1) {
                parents[p1] = p0;
                count--;
            }
        }
        return count;
    }
    
    int findSet(int v, int[] parents) {
        if (v != parents[v]) {
            parents[v] = findSet(parents[v],parents);     
        }
        return parents[v];
    } 
}
