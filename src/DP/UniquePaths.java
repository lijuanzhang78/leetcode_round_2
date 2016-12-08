package DP;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) return 0;
        
        int[] col = new int[n];
        for(int i = 0; i < n; i++) {
            col[i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                col[j] += col[j-1];
            }
        }
        return col[n-1];
    }

// 注意空间复杂度。没有必要用M*N的二维数组存放中间状态。
}
