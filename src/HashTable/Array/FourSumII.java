package HashTable.Array;

public class FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0 || D == null || D.length == 0) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (!map.containsKey(sum)) map.put(sum,0);
                map.put(sum, map.get(sum)+1);
            }
        }
        
        int res = 0;
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (map.containsKey(-sum)) res += map.get(-sum);
            }
        }
        return res;    
    }
}
