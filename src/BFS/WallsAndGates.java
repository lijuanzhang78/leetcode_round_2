package BFS;

// 这道题可以BFS 也可以
// BFS开始可以把所有gate都push到队列，multi-end BFS，应该理解为一层一层找最近的房间
//
public class WallsAndGates {
	final int[][] nei = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m, n;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        m = rooms.length;
        n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) q.offer(new int[]{i,j});
            }
        }
        
        int dis = 0;
        while(!q.isEmpty()) {
            int size = q.size(); // 这很重要，用于分层
            dis++;
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for(int[] d : nei) {
                    int x = d[0]+curr[0];
                    int y = d[1]+curr[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                        q.offer(new int[]{x,y});
                        rooms[x][y] = dis;
                    }
                }
            }
        }
    }
}
