package Passed;

public class PaintHouse {
	public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        int[] dpred = new int[n];
        int[] dpblue = new int[n];
        int[] dpgreen = new int[n];
        
        dpred[0] = costs[0][0]; dpblue[0] = costs[0][1]; dpgreen[0] = costs[0][2];
        
        for(int i = 1; i < n; i++) {
            dpred[i] = Math.min(dpblue[i-1], dpgreen[i-1]) + costs[i][0];
            dpblue[i] = Math.min(dpred[i-1], dpgreen[i-1]) + costs[i][1];
            dpgreen[i] = Math.min(dpred[i-1], dpblue[i-1]) + costs[i][2];
        }
        
        return Math.min(Math.min(dpred[n-1], dpblue[n-1]), dpgreen[n-1]);
    }
}
