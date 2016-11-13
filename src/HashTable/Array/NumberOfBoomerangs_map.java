package HashTable.Array;

public class NumberOfBoomerangs_map {
	public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dist = getDist(points[i], points[j]);
                if (!map.containsKey(dist)) {
                    map.put(dist,0);
                }
                map.put(dist,map.get(dist)+1);
            }
            
            for(int num : map.values()) {
                res += (num-1)*num;
            }
            map.clear();
        }
        return res;
    }
        
    int getDist(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
