package Passed;

public class SmallestRectangleEnclosingBlackPixels {
	int minx = Integer.MAX_VALUE;
    int miny = Integer.MAX_VALUE;
    int maxx = Integer.MIN_VALUE;
    int maxy = Integer.MIN_VALUE;
    int m, n;
    
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        m = image.length;
        n = image[0].length;
        dfs(x,y,image);
        return (maxx-minx+1) * (maxy-miny+1);
    }
    
    private void dfs(int x, int y, char[][] image) {
        if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] == '0') return;
        image[x][y] = '0';
        minx = Math.min(minx, x);
        maxx = Math.max(maxx, x);
        miny = Math.min(miny, y);
        maxy = Math.max(maxy, y);
        
        dfs(x+1, y, image);
        dfs(x-1, y, image);
        dfs(x, y+1, image);
        dfs(x, y-1, image);
    }
}
