package HashTable.Array;

public class FourSumII2 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0 || B == null || B.length == 0 ||
            C == null || C.length == 0 || D == null || D.length == 0) return 0;
        int res = 0;
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int sum1 = A[i] + B[j];
                if (!map.containsKey(sum1)) map.put(sum1,0);
                map.put(sum1, map.get(sum1)+1);
            }
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(-sum)) res += map.get(-sum);
            }
        }
        return res;
    }
}
