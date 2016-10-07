package DisjointSet;

public class DisjointSet {
	int[] parent; // parent to each vertex
	int[][] edges;
	DisjointSet(int n, int[][] edges) {
		parent = new int[n];
		this.edges = edges;
		
		// Initialize the parent of each vertex
		for(int i = 0; i < n; i++) {
			parent[i] = i;			
		}	
	}
	
	void union(int v1, int v2) {
		int p1 = findSet(v1);
		int p2 = findSet(v2);
		
		parent[p1] = p2;		
	}
	
	int findSet(int v) {
		if (parent[v] == v) {
			return v;			
		}
		parent[v] = findSet(parent[v]);
		return parent[v];
	}
	
	public static void main(String[] args) {
		int[][] edges = {{0,1}, {1,2}, {2,7}, {0,7}, {3,4}, {3,5}, {3,6}, {5,6}, {6,7}};
		DisjointSet ds = new DisjointSet(8, edges);
		for(int[] edge : edges) {
			ds.union(edge[0], edge[1]);	
		}
		
		for(int i = 0; i < 8; i++) {
			ds.parent[i] = ds.findSet(i);
		}
		
		return;
	}
}
