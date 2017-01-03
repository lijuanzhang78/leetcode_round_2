package DFS;

public class SmallestRectangleEnclosingBlackPixels {
	int[][] nei = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        int[] rangex = new int[2];
        int[] rangey = new int[2];
        rangex[0] = Integer.MAX_VALUE;
        rangey[0] = Integer.MAX_VALUE;
        rangex[1] = Integer.MIN_VALUE;
        rangey[1] = Integer.MIN_VALUE;
        
        dfs(image,x,y,rangex,rangey);
        
        return (rangex[1]-rangex[0]+1)*(rangey[1]-rangey[0]+1);
    }
    
    void dfs(char[][] image, int x, int y, int[] rangex, int[] rangey) {
        int m = image.length;
        int n = image[0].length;
        image[x][y] = '2';
        rangex[0] = Math.min(rangex[0],x);
        rangex[1] = Math.max(rangex[1],x);
        rangey[0] = Math.min(rangey[0],y);
        rangey[1] = Math.max(rangey[1],y);
        
        for(int[] d : nei) {
            int xx = d[0]+x;
            int yy = d[1]+y;
            if (xx >= m || xx < 0 || yy >= n || yy < 0 || image[xx][yy] != '1') continue;
            dfs(image,xx,yy,rangex,rangey);
        }
    }
}
