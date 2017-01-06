package UnionFind;

public class NumberOfIslandsII {
	int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int[] parents;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        if (positions == null || positions.length == 0 || positions[0].length == 0) return new ArrayList<Integer>();
        parents = new int[m*n];
        Arrays.fill(parents,-1);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < positions.length; i++) {
            int[] pos = positions[i];
            parents[pos[0]*n+pos[1]] = pos[0]*n+pos[1];
            count++;
            for(int[] dir : dirs) {
                int x = dir[0] + pos[0];
                int y = dir[1] + pos[1];
                if (x < 0 || x >= m || y < 0 || y >= n || parents[x*n+y] == -1) continue;
                int p0 = findSet(pos[0]*n+pos[1]);
                int p1 = findSet(x*n+y);
                if (p0 != p1) {
                    parents[p0] = p1;
                    count--;
                }
            }
            res.add(count);       
        }
        return res;
    }
    
    int findSet(int i) {
        if (parents[i] != i) {
            parents[i] = findSet(parents[i]);
        }
        return parents[i];
    }
}
