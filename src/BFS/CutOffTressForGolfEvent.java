package BFS;

public class CutOffTressForGolfEvent {
	public int cutOffTree(List<List<Integer>> forest) {
        if (forest.size() == 0 || forest.get(0).size() == 0) return 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        int m = forest.size(), n = forest.get(0).size();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.offer(new int[] {i,j,forest.get(i).get(j)});}    
            }
        }
        
        int[] start = {0,0};
        int sum = 0;
        while(pq.size() > 0) {
            int[] tree = pq.poll();
            int step = minStep(start,new int[]{tree[0],tree[1]},forest,m,n);
            if (step == -1) return -1;
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;    
    }
    
    int minStep(int[] start, int[] tree, List<List<Integer>> forest, int m, int n) {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        
        int step = 0;
        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;
                for(int[] d : dirs) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x >=0 && x < m && y >=0 && y < n && forest.get(x).get(y) >= 1 && !visited[x][y]) {
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            step++;            
        }
        return -1;
    }
}
